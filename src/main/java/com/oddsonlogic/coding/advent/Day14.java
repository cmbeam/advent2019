package com.oddsonlogic.coding.advent;

import java.util.*;

public class Day14 {

    int oreCount = 0;
    HashMap<String,Integer> availableResources = new HashMap<>();
    HashMap<String,ChemFormula> formulas = new HashMap<>();

    public Day14(){

        String data ="2 LGNW, 1 FKHJ => 3 KCRD\n" +
                "5 FVXTS => 5 VSVK\n" +
                "1 RBTG => 8 FKHJ\n" +
                "2 TLXRM, 1 VWJSD => 8 CDGX\n" +
                "1 MVSL, 2 PZDR, 9 CHJRF => 8 CLMZ\n" +
                "11 BMSFK => 5 JMSWX\n" +
                "10 XRMC => 1 MQLFC\n" +
                "20 ZPWQB, 1 SBJTD, 9 LWZXV => 4 JFZNR\n" +
                "2 FVXTS => 3 FBHT\n" +
                "10 ZPWQB => 8 LGNW\n" +
                "5 WBDGL, 16 KZHQ => 2 FVXTS\n" +
                "124 ORE => 7 BXFVM\n" +
                "5 KCRD => 1 RNVMC\n" +
                "5 CGPZC, 4 WJCT, 1 PQXV => 8 VKQXP\n" +
                "4 KFVH => 4 FGTKD\n" +
                "11 QWQG => 6 LWZXV\n" +
                "9 ZMZPB, 8 KFVH, 5 FNPRJ => 3 VKVP\n" +
                "1 LFQW, 8 PQXV, 2 TLXRM, 1 VKQXP, 1 BMSFK, 1 QKJPV, 3 JZCFD, 8 VWJSD => 6 WXBC\n" +
                "2 SLDWK, 32 JZCFD, 10 RNVMC, 1 FVXTS, 34 LGTX, 1 NTPZK, 1 VKQXP, 1 QTKL => 9 LDZV\n" +
                "31 FBHT => 2 BMSFK\n" +
                "35 KZHQ, 3 ZPWQB => 3 PCNVM\n" +
                "6 DRSG, 1 TDRK, 1 VSVK => 2 VWJSD\n" +
                "3 DGMH => 3 ZPWQB\n" +
                "162 ORE => 9 RBTG\n" +
                "11 LFQW, 1 LPQCK => 8 LGTX\n" +
                "8 MQLFC => 1 SBJTD\n" +
                "1 KGTB => 9 TGNB\n" +
                "1 BXFVM, 1 ZMZPB => 8 FNPRJ\n" +
                "1 PCNVM, 15 ZSZBQ => 4 PQXV\n" +
                "15 XRMC => 9 ZSZBQ\n" +
                "18 VWJSD, 12 CHJRF => 6 KTPH\n" +
                "8 RBTG, 5 ZMZPB => 6 KFVH\n" +
                "6 SLDWK => 1 XVTRS\n" +
                "3 VSVK, 6 BMSFK, 3 NTPZK => 1 JZCFD\n" +
                "3 FVXTS, 2 MTMKN => 5 CHJRF\n" +
                "9 FNPRJ => 2 QWQG\n" +
                "1 FBHT, 1 MVSL, 1 FNPRJ => 1 DRSG\n" +
                "35 LPQCK, 19 LWZXV, 28 LGNW => 5 TLXRM\n" +
                "5 NKMV => 3 QKJPV\n" +
                "3 MGZM, 2 TGNB => 8 PZDR\n" +
                "2 FKHJ => 2 WBDGL\n" +
                "1 NKMV => 1 KGTB\n" +
                "129 ORE => 7 ZMZPB\n" +
                "3 LMNQ, 2 BMSFK, 4 RNVMC, 4 KGTB, 4 DRSG, 2 JFZNR, 7 QTKL => 4 CKQZ\n" +
                "1 MQLFC => 7 MGZM\n" +
                "7 SLDWK, 2 KCRD => 4 WJCT\n" +
                "1 QKJPV => 4 LPQCK\n" +
                "1 JFZNR => 6 TDRK\n" +
                "4 CLMZ, 1 LGTX => 9 PMSZG\n" +
                "6 QWQG => 8 CGPZC\n" +
                "10 QWQG => 6 LMNQ\n" +
                "2 PMSZG, 1 VKVP => 3 QTKL\n" +
                "2 DGMH => 8 KZHQ\n" +
                "14 RBTG => 9 DGMH\n" +
                "62 RNVMC, 4 KTPH, 20 XVTRS, 7 JZCFD, 18 CDGX, 13 WXBC, 14 LDZV, 2 CKQZ, 33 FNPRJ => 1 FUEL\n" +
                "8 KGTB, 1 JMSWX => 7 NTPZK\n" +
                "1 VKVP, 7 DGMH => 7 NKMV\n" +
                "4 LPQCK => 5 MVSL\n" +
                "6 KGTB => 2 LFQW\n" +
                "2 FGTKD => 9 SLDWK\n" +
                "1 WBDGL, 1 ZMZPB, 1 DGMH => 6 XRMC\n" +
                "4 VKVP => 7 MTMKN";


        data="10 ORE => 10 A\n" +
                "1 ORE => 1 B\n" +
                "7 A, 1 B => 1 C\n" +
                "7 A, 1 C => 1 D\n" +
                "7 A, 1 D => 1 E\n" +
                "7 A, 1 E => 1 FUEL";
/*

        data="9 ORE => 2 A\n" +
                "8 ORE => 3 B\n" +
                "7 ORE => 5 C\n" +
                "3 A, 4 B => 1 AB\n" +
                "5 B, 7 C => 1 BC\n" +
                "4 C, 1 A => 1 CA\n" +
                "2 AB, 3 BC, 4 CA => 1 FUEL";

*/






        List<String> dataArray = Arrays.asList(data.split("\n"));
        for (String line : dataArray) {
            String[] formula = line.split(" => ");
            System.out.println(formula[0]+"  | "+formula[1]);
            List<String> ingredients = Arrays.asList(formula[0].split(", "));
            HashMap<String,Integer> ingredientsMap = new HashMap<>();
            for(String ingredient : ingredients){
                ingredientsMap.put(ingredient.split(" ")[1],Integer.parseInt(ingredient.split(" ")[0]));
                availableResources.put(ingredient.split(" ")[1], 0);
            }
            availableResources.put("FUEL",0);


            ChemFormula chemFormula = new ChemFormula();
            chemFormula.name = formula[1].split(" ")[1];
            chemFormula.quantity = Integer.parseInt(formula[1].split(" ")[0]);
            chemFormula.ingredients=ingredientsMap;
            formulas.put(chemFormula.name,chemFormula);

        }

    }

    public static void main(String[] args) {
        Day14 object = new Day14();

        int oreNneeded = 0;

        ChemFormula fuelFormula = object.formulas.get("FUEL");
        HashMap<String,Integer> ingredientsMap = fuelFormula.ingredients;
        for(Map.Entry<String, Integer> ingredient : ingredientsMap.entrySet()) {
            object.produce("FUEL",ingredient,fuelFormula.quantity,fuelFormula.quantity);

        }

        System.out.println("Ore: "+object.oreCount);

    }

    int calculate(Map.Entry<String,Integer> ingredient)
    {
        System.out.println(ingredient.getKey()+" Needed: "+ingredient.getValue());
        int inPlayResources = availableResources.get(ingredient.getKey());


        int needed = ingredient.getValue() - inPlayResources;
        if(needed <= 0){
            availableResources.replace(ingredient.getKey(),inPlayResources - needed);
            return needed;
        }


        int lowestAmount = 0;
        if(ingredient.getKey().equals("ORE")){
            oreCount=oreCount+needed;
            //int amountReturned = needed /
            lowestAmount = needed;//ingredient.getValue();

    }
        else{
            ChemFormula subFormula = formulas.get(ingredient.getKey());
            HashMap<String,Integer> ingredientsMap = subFormula.ingredients;
            for(Map.Entry<String, Integer> subIngredient : ingredientsMap.entrySet()) {

                lowestAmount = lowestAmount+calculate(subIngredient);
                System.out.println("Sub calculation  chemical: "+ingredient.getKey()+"    Ingredient: "+subIngredient.getKey()+"  amount: "+lowestAmount);
            }
        }

        availableResources.replace(ingredient.getKey(),Integer.valueOf(inPlayResources + (lowestAmount-needed)));
        System.out.println(ingredient.getKey()+" in reserve: "+availableResources.get(ingredient.getKey()));

        return lowestAmount;
    }

    int produce(String name,Map.Entry<String,Integer> ingredient,int increment, int needed){
        System.out.println(name+" Requested: "+needed);

        if(ingredient.getKey().equals("ORE")){
            int localProduced = 0;
            boolean enough = false;
            while(!enough){
                localProduced = localProduced + increment;
                oreCount=oreCount+ingredient.getValue();
                if(localProduced >= needed)
                    enough = true;

            }

            //int amountReturned = needed /
            System.out.println(name+" Produced: "+localProduced);
            return localProduced;

        }
        else{
            ChemFormula subFormula = formulas.get(ingredient.getKey());
            HashMap<String,Integer> ingredientsMap = subFormula.ingredients;

            int localProduced=availableResources.get(name);
            for(Map.Entry<String, Integer> subIngredient : ingredientsMap.entrySet()) {
                localProduced = availableResources.get(name);;
                while(localProduced<needed){
                    localProduced = localProduced + produce(ingredient.getKey(),subIngredient,subFormula.quantity,ingredient.getValue());;

                }

                System.out.println(name+" Produced: "+localProduced);
                availableResources.replace(name,localProduced-needed);
            }
            return localProduced;
        }
    }
}
