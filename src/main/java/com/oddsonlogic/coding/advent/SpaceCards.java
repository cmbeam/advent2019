package com.oddsonlogic.coding.advent;

public class SpaceCards {

    int[] deck;
    int deckSize;

    public SpaceCards(int deckSize){
        this.deckSize = deckSize;
        this.deck = new int[deckSize];
        for (int i = 0; i < deckSize ; i++) {
            deck[i] = i;
        }
    }

    public void dealIntoNewStack(){
        int[] tempDeck = new int[deckSize];
        for (int i = 0; i < deckSize ; i++) {
            tempDeck[deckSize-i-1] = deck[i];

        }
        deck = tempDeck;
    }

    public void cut(int n){
        int[] tempDeck = new int[deckSize];
        if(n>0){
            int[] cut = new int[n];
            for (int i = 0; i < n; i++) {
                cut[i] = deck[i];
            }
            for (int i = 0; i <deckSize-n ; i++) {
                tempDeck[i] = deck[i+n];
            }
            for (int i = 0; i < n ; i++) {
                tempDeck[deckSize-n+i] = cut[i];
            }
            deck = tempDeck;

        }
        else{
            n=Math.abs(n);

            int[] cut = new int[n];
            for (int i = 0; i < n; i++) {
                cut[i] = deck[deckSize-n+i];
            }
            for (int i = 0; i <deckSize-n ; i++) {
                tempDeck[i+n] = deck[i];
            }
            for (int i = 0; i < n ; i++) {
                tempDeck[i] = cut[i];
            }
            deck = tempDeck;

        }
    }

    public void dealWithIncrement(int n){
        int[] tempDeck = new int[deckSize];

        for (int i = 0; i < deckSize ; i++) {
            int position = i*n%deckSize;
            tempDeck[i*n%deckSize] = deck[i];
        }

        deck=tempDeck;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < deckSize ; i++) {
            sb.append(deck[i]);
            sb.append(",");
        }
        return sb.toString();
    }

    public int findPosition(int card) {
        for (int i = 0; i < deckSize; i++) {
            if (deck[i] == card)
                return i;

        }
        return -99999;
    }



}
