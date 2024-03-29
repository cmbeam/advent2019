package com.oddsonlogic.coding.advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Day6 {
    public static void main(String[] args) {
        String data="F4H)7LQ\n" +
                "TG2)G6N\n" +
                "Y6X)5MP\n" +
                "TK5)5KN\n" +
                "LLY)WKD\n" +
                "XL2)94R\n" +
                "BTG)PQ1\n" +
                "DLS)LR5\n" +
                "X4H)C93\n" +
                "JK5)WB1\n" +
                "GRQ)9RF\n" +
                "YVJ)1SJ\n" +
                "XPV)T62\n" +
                "N6B)735\n" +
                "ZBD)C78\n" +
                "XYT)LSN\n" +
                "TTW)JQY\n" +
                "MP6)68B\n" +
                "BVT)VFN\n" +
                "YTZ)83Q\n" +
                "DP5)FCJ\n" +
                "61Q)SYF\n" +
                "7JG)D23\n" +
                "5SF)QJS\n" +
                "8BW)F52\n" +
                "4DB)ZLT\n" +
                "F1F)QQL\n" +
                "3XG)RYX\n" +
                "54Z)SJ8\n" +
                "KDD)44C\n" +
                "GGJ)7LV\n" +
                "DRC)P22\n" +
                "XD7)DXM\n" +
                "G9Y)VLV\n" +
                "7XC)BV7\n" +
                "265)Y7N\n" +
                "JN4)8XM\n" +
                "RKX)ZDK\n" +
                "556)H6B\n" +
                "WKD)YDF\n" +
                "Z3T)B4N\n" +
                "T83)ZMP\n" +
                "3M2)5TN\n" +
                "83Q)SX9\n" +
                "9R9)X4H\n" +
                "ZV9)YHM\n" +
                "PG8)7WP\n" +
                "23M)4N7\n" +
                "SX9)QJR\n" +
                "V5J)VNL\n" +
                "XJP)M3V\n" +
                "YR3)DZX\n" +
                "6VZ)HQ1\n" +
                "QQV)BCZ\n" +
                "JC2)2FQ\n" +
                "JCS)SJC\n" +
                "46V)H1F\n" +
                "F6M)17N\n" +
                "S7Q)7R8\n" +
                "HG7)HQC\n" +
                "KGP)MD8\n" +
                "X3R)679\n" +
                "JWQ)ZNT\n" +
                "VNG)WHN\n" +
                "B11)YB9\n" +
                "FBM)BLX\n" +
                "26Q)QTZ\n" +
                "5MH)72G\n" +
                "DK8)BJJ\n" +
                "8C2)TYH\n" +
                "CCF)1Y5\n" +
                "5GF)X48\n" +
                "MP2)LRM\n" +
                "GT5)1SZ\n" +
                "XJK)3ZF\n" +
                "WNX)CNN\n" +
                "JN4)ZWG\n" +
                "WK1)8DX\n" +
                "KPN)3TW\n" +
                "GMC)ZBD\n" +
                "ZX5)9RD\n" +
                "CD4)NC7\n" +
                "H1F)4GC\n" +
                "VLV)DFW\n" +
                "2F3)7P2\n" +
                "G6S)85X\n" +
                "49H)K1P\n" +
                "WCQ)Y93\n" +
                "TF9)HL7\n" +
                "2FQ)D4B\n" +
                "992)7JG\n" +
                "JBH)VHV\n" +
                "53N)WMR\n" +
                "M3V)43Q\n" +
                "C8B)MFX\n" +
                "D4C)PKS\n" +
                "855)4HH\n" +
                "WWF)GGM\n" +
                "KKR)88M\n" +
                "COM)KHS\n" +
                "LDN)CRH\n" +
                "FRB)KYK\n" +
                "FYC)R85\n" +
                "L28)WBT\n" +
                "CM7)LT9\n" +
                "5WV)Y7S\n" +
                "DF6)Y12\n" +
                "JDQ)2KF\n" +
                "8Y4)XF2\n" +
                "SP2)W7T\n" +
                "7C3)H8S\n" +
                "BD8)51R\n" +
                "Q96)7WM\n" +
                "BCX)RG4\n" +
                "1CW)8VH\n" +
                "CSW)K6P\n" +
                "JRR)KSF\n" +
                "T7W)QBT\n" +
                "94R)XSK\n" +
                "QD9)ZDD\n" +
                "LD8)HC7\n" +
                "K1P)698\n" +
                "K5H)MDY\n" +
                "ZWG)C8B\n" +
                "X48)Y9L\n" +
                "6RH)654\n" +
                "SRH)M15\n" +
                "3ZF)LD4\n" +
                "T3W)1TS\n" +
                "C93)MYT\n" +
                "D8S)HM8\n" +
                "VQB)SYN\n" +
                "XPX)W37\n" +
                "QLS)1F8\n" +
                "JXQ)H9F\n" +
                "ZLT)BMY\n" +
                "758)9R9\n" +
                "WMR)GP1\n" +
                "3ZQ)K1Q\n" +
                "F52)52M\n" +
                "Q4B)CM7\n" +
                "RPW)VYB\n" +
                "YYV)CTL\n" +
                "7LV)53N\n" +
                "3WL)KX6\n" +
                "QCG)4SX\n" +
                "NYK)HVJ\n" +
                "F7G)JLG\n" +
                "RZH)B14\n" +
                "PWD)963\n" +
                "X5W)9MC\n" +
                "NJS)3TR\n" +
                "1MQ)JBH\n" +
                "36D)SY4\n" +
                "YDF)Y88\n" +
                "8KX)6VZ\n" +
                "215)TW9\n" +
                "S1V)5CN\n" +
                "BWH)LV7\n" +
                "2XT)CGT\n" +
                "ZRK)TG2\n" +
                "MFB)L35\n" +
                "MHT)M4C\n" +
                "NMY)KGP\n" +
                "9RF)C5T\n" +
                "SKY)X5D\n" +
                "HJ6)Y9C\n" +
                "TGT)2ZQ\n" +
                "YQQ)P89\n" +
                "Q4X)28M\n" +
                "3V2)7Q5\n" +
                "P3V)756\n" +
                "L1V)M9L\n" +
                "VZT)P6S\n" +
                "N6T)MP6\n" +
                "BHL)TLD\n" +
                "S6W)79Q\n" +
                "GB5)XD7\n" +
                "6Z7)X5W\n" +
                "CFC)JS8\n" +
                "2DJ)LZK\n" +
                "4HH)CXG\n" +
                "K1Q)TTW\n" +
                "B5D)HLF\n" +
                "8ZR)34Z\n" +
                "Q19)NV8\n" +
                "28L)BHL\n" +
                "DVT)X8D\n" +
                "QGH)L5N\n" +
                "Q9J)X78\n" +
                "WM4)TSP\n" +
                "RG4)514\n" +
                "4K6)M1M\n" +
                "W8Y)NZ2\n" +
                "ZRQ)VJM\n" +
                "VT8)B6X\n" +
                "RY1)JDQ\n" +
                "X8D)C1G\n" +
                "G6N)MN1\n" +
                "6XJ)NMP\n" +
                "ZMP)7G2\n" +
                "1JD)XL5\n" +
                "M4C)G2F\n" +
                "Q3N)W7Z\n" +
                "PWR)3NF\n" +
                "2J3)215\n" +
                "F33)GK9\n" +
                "SDR)5XZ\n" +
                "53N)TZT\n" +
                "QJS)72Q\n" +
                "KWT)6Q6\n" +
                "SX9)771\n" +
                "4DB)97W\n" +
                "DN1)VY9\n" +
                "ZH1)SCN\n" +
                "F52)GH4\n" +
                "HS1)8N5\n" +
                "MYV)CXP\n" +
                "XC1)LD8\n" +
                "F5F)WCQ\n" +
                "4ZC)P3V\n" +
                "LR5)XL2\n" +
                "2H1)BMH\n" +
                "K52)858\n" +
                "NVX)85N\n" +
                "5JW)XNL\n" +
                "5RM)TF8\n" +
                "TW3)4T8\n" +
                "3ZJ)KZZ\n" +
                "WXS)37V\n" +
                "72T)RR4\n" +
                "ZZC)Q19\n" +
                "3VM)ZL3\n" +
                "X2C)MFB\n" +
                "91H)TJF\n" +
                "GJD)CDC\n" +
                "LSY)FLK\n" +
                "LRM)L4P\n" +
                "65C)Z3P\n" +
                "7JZ)2XT\n" +
                "QJR)J4F\n" +
                "MKM)L46\n" +
                "S2S)3V9\n" +
                "MH9)PYK\n" +
                "ZBW)1TV\n" +
                "MDY)QXW\n" +
                "DXV)VGW\n" +
                "NB1)34B\n" +
                "9VS)YWD\n" +
                "GJL)2F3\n" +
                "1BH)J4K\n" +
                "BLX)HY2\n" +
                "HDN)TK5\n" +
                "Q96)JLD\n" +
                "DWV)MV8\n" +
                "BDF)NGQ\n" +
                "CFC)HKM\n" +
                "QG9)DK8\n" +
                "TNH)1S9\n" +
                "WHN)HC9\n" +
                "WP3)VQB\n" +
                "QXW)SKN\n" +
                "QYZ)DG2\n" +
                "6N9)NDH\n" +
                "Q7X)F33\n" +
                "6K1)YBK\n" +
                "WK9)SKY\n" +
                "L5Y)X7V\n" +
                "1SZ)J2X\n" +
                "8Y1)2J3\n" +
                "WFK)MTK\n" +
                "YKR)YK5\n" +
                "VGW)YYV\n" +
                "PXQ)3WL\n" +
                "21L)272\n" +
                "1CR)2DJ\n" +
                "SXV)J26\n" +
                "V41)2VS\n" +
                "SRW)5JS\n" +
                "97W)K17\n" +
                "R7R)C5H\n" +
                "9CC)P59\n" +
                "KLR)DCD\n" +
                "SNQ)JB6\n" +
                "43Q)JW5\n" +
                "KQ9)6XJ\n" +
                "W84)HSM\n" +
                "PYS)YQQ\n" +
                "47W)2DG\n" +
                "NDR)PXQ\n" +
                "7JT)WZX\n" +
                "2N6)SZ8\n" +
                "4T8)FV7\n" +
                "9DX)BC1\n" +
                "JS8)1CV\n" +
                "D4B)YMD\n" +
                "NJS)GY1\n" +
                "GV8)91D\n" +
                "SCM)818\n" +
                "L5N)GDV\n" +
                "T62)47D\n" +
                "SQT)R4V\n" +
                "ZBT)9F3\n" +
                "LDB)NX7\n" +
                "WTF)1WN\n" +
                "BLX)FMW\n" +
                "GZB)KLR\n" +
                "VJM)NPD\n" +
                "GGM)BFL\n" +
                "52M)49P\n" +
                "C6Z)3JT\n" +
                "WDX)WNX\n" +
                "C5T)2YY\n" +
                "QX9)96M\n" +
                "TLN)HQQ\n" +
                "BV7)51L\n" +
                "7WM)5DB\n" +
                "ZKK)YVG\n" +
                "SCN)MRM\n" +
                "8QY)7KX\n" +
                "8FS)MJG\n" +
                "19S)WV9\n" +
                "QQV)KJY\n" +
                "6Z5)FYC\n" +
                "ZYL)RG5\n" +
                "QMR)PH6\n" +
                "68B)7FD\n" +
                "72Q)S1V\n" +
                "BCB)C4Q\n" +
                "NC7)9T8\n" +
                "2XT)Q3N\n" +
                "54D)CWD\n" +
                "TSP)X2C\n" +
                "HFY)LNL\n" +
                "HL7)54Z\n" +
                "5KN)DZK\n" +
                "93Q)3PH\n" +
                "MD8)Y7L\n" +
                "CT6)RPW\n" +
                "YSD)M25\n" +
                "ZWG)DVX\n" +
                "K95)Q8T\n" +
                "C38)JH7\n" +
                "HNX)LSG\n" +
                "GZB)T82\n" +
                "WVJ)J8R\n" +
                "3JP)8BW\n" +
                "TVN)B82\n" +
                "524)CB6\n" +
                "CHZ)GZB\n" +
                "1F3)YWK\n" +
                "CXG)98G\n" +
                "CR5)VNG\n" +
                "Q8T)DVT\n" +
                "H6B)K5R\n" +
                "B49)6MZ\n" +
                "4QF)9YT\n" +
                "3YL)F1F\n" +
                "2KF)N7M\n" +
                "9MC)K4Z\n" +
                "JLD)L9V\n" +
                "3GR)FYS\n" +
                "VHH)D5D\n" +
                "NPD)L7P\n" +
                "PQ1)Z1K\n" +
                "3S4)RBD\n" +
                "YVG)2WN\n" +
                "YBK)RKX\n" +
                "HS6)KQ5\n" +
                "G3Z)91H\n" +
                "L5Q)LMN\n" +
                "M15)KQ9\n" +
                "MZD)JSX\n" +
                "3PH)T1M\n" +
                "5Y2)1N7\n" +
                "NX5)YM5\n" +
                "VL4)69H\n" +
                "2GS)1D6\n" +
                "47T)LHW\n" +
                "FW3)4K6\n" +
                "XR4)9VK\n" +
                "MQ9)D4S\n" +
                "R2N)X6T\n" +
                "HM8)JTX\n" +
                "GGR)892\n" +
                "TKL)QLS\n" +
                "B8Y)Q4P\n" +
                "3KF)4VM\n" +
                "8BS)9P2\n" +
                "SYN)2ZC\n" +
                "KJZ)GGJ\n" +
                "CW3)R28\n" +
                "GQN)Y62\n" +
                "R9R)B5D\n" +
                "6FJ)TF9\n" +
                "8N4)JGY\n" +
                "W66)W2D\n" +
                "T78)M11\n" +
                "RR4)G9Y\n" +
                "5B8)3M2\n" +
                "C8Q)13M\n" +
                "4HM)BCB\n" +
                "FQV)N6B\n" +
                "LGN)DST\n" +
                "MX9)P4W\n" +
                "VT7)4T2\n" +
                "BMH)JJB\n" +
                "YZF)MP2\n" +
                "B7D)HT4\n" +
                "H7R)X2F\n" +
                "8X8)D4H\n" +
                "RG9)2VM\n" +
                "YB9)Q7X\n" +
                "TBY)FLL\n" +
                "GP1)3BJ\n" +
                "HL9)HFT\n" +
                "KQ5)LJH\n" +
                "5FQ)D4C\n" +
                "BJJ)MX9\n" +
                "L3B)45C\n" +
                "TQN)32C\n" +
                "GH4)STG\n" +
                "82M)HSH\n" +
                "N7M)PSD\n" +
                "5V7)5TD\n" +
                "223)36G\n" +
                "4L5)ZYJ\n" +
                "9VK)62Q\n" +
                "1WN)CLG\n" +
                "37Z)JXQ\n" +
                "PKS)H6C\n" +
                "CXL)1TD\n" +
                "3YV)F6M\n" +
                "63H)943\n" +
                "X42)ZGP\n" +
                "TLD)S3W\n" +
                "96Y)2H1\n" +
                "1DM)FC8\n" +
                "6SR)QJP\n" +
                "8F9)K95\n" +
                "9T6)GQ6\n" +
                "SCZ)969\n" +
                "3TR)3VX\n" +
                "X42)RDS\n" +
                "13M)RZH\n" +
                "TV1)LDN\n" +
                "5PV)XR4\n" +
                "TKK)8K2\n" +
                "KJZ)QLH\n" +
                "HC9)ZBT\n" +
                "MKB)56X\n" +
                "KM9)GQ5\n" +
                "H9B)FKT\n" +
                "QJS)HM6\n" +
                "NV8)5JW\n" +
                "H2H)Z99\n" +
                "56W)3S4\n" +
                "586)82M\n" +
                "7XK)3XG\n" +
                "4T2)HTN\n" +
                "K52)4F6\n" +
                "NNT)JN6\n" +
                "WB1)X42\n" +
                "LZK)SKD\n" +
                "XDN)TW3\n" +
                "P21)WFK\n" +
                "7Y8)4DB\n" +
                "D5J)V5J\n" +
                "WKD)F64\n" +
                "M1M)5F4\n" +
                "F33)BPZ\n" +
                "SPZ)SDC\n" +
                "16V)J2B\n" +
                "7X9)YZF\n" +
                "7YX)95R\n" +
                "RG5)MJY\n" +
                "2NM)QKC\n" +
                "BPZ)ZBW\n" +
                "VK6)G61\n" +
                "STG)46V\n" +
                "39L)R1R\n" +
                "ZG9)4BB\n" +
                "HDN)9YR\n" +
                "68W)3M1\n" +
                "1M6)561\n" +
                "5JZ)D1W\n" +
                "3VX)JTH\n" +
                "SLY)HDN\n" +
                "ZDK)2NG\n" +
                "5TD)54D\n" +
                "W37)9FG\n" +
                "5JS)NB1\n" +
                "DTY)KRB\n" +
                "37V)9CM\n" +
                "F51)3ZJ\n" +
                "JKR)B8Y\n" +
                "D1W)WK9\n" +
                "KXF)DWV\n" +
                "ZHB)7KY\n" +
                "VSM)B8P\n" +
                "8BW)FW3\n" +
                "2LT)5VB\n" +
                "29W)1HY\n" +
                "3VX)5V7\n" +
                "WBT)6QN\n" +
                "KNS)SH6\n" +
                "WP1)4HM\n" +
                "CQW)3QW\n" +
                "PFB)43J\n" +
                "GBK)YC5\n" +
                "LVW)5PV\n" +
                "VHK)VJH\n" +
                "2TS)LDB\n" +
                "ZHF)PTT\n" +
                "VJH)MQ9\n" +
                "3HY)VF4\n" +
                "2Z7)X5C\n" +
                "43P)FHB\n" +
                "Z75)X3G\n" +
                "LL7)76L\n" +
                "LHW)VF8\n" +
                "1TV)8C2\n" +
                "5VB)SPZ\n" +
                "Y62)HNG\n" +
                "HSM)VVR\n" +
                "9SY)6N7\n" +
                "Z3P)CHB\n" +
                "J2B)SRH\n" +
                "J26)YSB\n" +
                "2KW)DBJ\n" +
                "99Z)SCM\n" +
                "7ZK)8NL\n" +
                "R7R)2GS\n" +
                "SH6)BGY\n" +
                "VTH)N44\n" +
                "ML1)FF8\n" +
                "LH8)8Y1\n" +
                "F48)3VM\n" +
                "7KX)7HX\n" +
                "VFN)PFB\n" +
                "QJP)RJB\n" +
                "4L5)48C\n" +
                "VVR)MCW\n" +
                "8N4)NDR\n" +
                "756)PWK\n" +
                "NDH)X3K\n" +
                "NNT)H9B\n" +
                "L28)56W\n" +
                "RBD)W57\n" +
                "KXF)PSP\n" +
                "2HJ)KJZ\n" +
                "6KX)589\n" +
                "FV7)NMY\n" +
                "QMC)2TS\n" +
                "96Y)2HJ\n" +
                "HNG)WDX\n" +
                "4BB)R2G\n" +
                "51L)L28\n" +
                "G5W)QTM\n" +
                "LD9)NMN\n" +
                "FRF)4JG\n" +
                "Z67)9GC\n" +
                "Q2T)L91\n" +
                "CXW)K5H\n" +
                "YQN)VL4\n" +
                "K5R)QZ5\n" +
                "17N)H3K\n" +
                "SDC)4J1\n" +
                "CLG)ZZF\n" +
                "C74)MH9\n" +
                "TV6)39L\n" +
                "RP1)Y1Y\n" +
                "KHS)S4H\n" +
                "827)DCX\n" +
                "DS9)5PG\n" +
                "79Q)G5W\n" +
                "V66)ZTL\n" +
                "ZTL)6X1\n" +
                "DZX)VT7\n" +
                "PW8)G3Z\n" +
                "F4K)PXM\n" +
                "GHW)FP9\n" +
                "6XK)NNT\n" +
                "QKC)CDS\n" +
                "C78)K6F\n" +
                "1HY)WJP\n" +
                "3YL)HLN\n" +
                "Y7S)KLJ\n" +
                "QTN)H6Y\n" +
                "WS5)XJP\n" +
                "1D3)T7W\n" +
                "5DB)6J3\n" +
                "CHB)WVV\n" +
                "93Q)QX9\n" +
                "CMQ)W8Y\n" +
                "DTQ)F1G\n" +
                "PRL)9HS\n" +
                "J2X)TJX\n" +
                "TDX)KT1\n" +
                "YZQ)G3K\n" +
                "CM7)F7G\n" +
                "3V9)9T6\n" +
                "W3X)BD8\n" +
                "NZ2)MHT\n" +
                "C48)D47\n" +
                "XL5)M1P\n" +
                "F4H)1NP\n" +
                "NJK)3LX\n" +
                "589)LG7\n" +
                "YSB)GBK\n" +
                "X5C)CRV\n" +
                "R5L)WXS\n" +
                "HC7)Q4X\n" +
                "514)GX8\n" +
                "Y7S)HG7\n" +
                "9FG)SRW\n" +
                "Y12)M99\n" +
                "45H)R5L\n" +
                "NXV)2CK\n" +
                "574)VHK\n" +
                "YNG)VTH\n" +
                "QYZ)ZYL\n" +
                "32C)XHF\n" +
                "D41)W9K\n" +
                "HLF)9PQ\n" +
                "W92)VZT\n" +
                "47D)MLP\n" +
                "HY2)QMC\n" +
                "7G2)SLY\n" +
                "DXV)MKB\n" +
                "3BJ)HL9\n" +
                "W7T)PG8\n" +
                "5TN)MQW\n" +
                "9GC)KWT\n" +
                "X48)Y6X\n" +
                "7P2)S8B\n" +
                "5VX)GMC\n" +
                "DG2)5X8\n" +
                "QZ5)5MH\n" +
                "6YF)FZ1\n" +
                "44C)2HT\n" +
                "7R8)L5Q\n" +
                "7PM)6VD\n" +
                "YWK)R3B\n" +
                "J92)W8M\n" +
                "H6Y)QGH\n" +
                "H9F)5JZ\n" +
                "P6S)T77\n" +
                "8K2)38J\n" +
                "D5D)4D7\n" +
                "FP9)QQV\n" +
                "GCS)H7R\n" +
                "DCC)9SN\n" +
                "1TV)72T\n" +
                "7FD)7CL\n" +
                "6J3)QRL\n" +
                "MSF)64F\n" +
                "3M7)CD4\n" +
                "128)3KF\n" +
                "855)TV6\n" +
                "8NL)WM4\n" +
                "ZCY)C48\n" +
                "9NN)D5J\n" +
                "QTM)W3N\n" +
                "QG9)1K4\n" +
                "2KF)NWL\n" +
                "8GL)VHH\n" +
                "7LQ)7XK\n" +
                "YHM)ZG9\n" +
                "LGN)YKR\n" +
                "MYT)3MK\n" +
                "L96)YQN\n" +
                "D4S)SRP\n" +
                "1QP)G2S\n" +
                "WM4)MSQ\n" +
                "LTV)YCM\n" +
                "2TT)6FJ\n" +
                "C17)8TF\n" +
                "5C8)YZQ\n" +
                "WVV)JVR\n" +
                "P89)GJD\n" +
                "GGQ)8GL\n" +
                "PK7)F48\n" +
                "5WR)MB5\n" +
                "Y62)HT9\n" +
                "D41)QG9\n" +
                "DFW)LKM\n" +
                "BV3)96Y\n" +
                "3SF)93Q\n" +
                "C78)7C3\n" +
                "MFX)3M7\n" +
                "N44)1M8\n" +
                "WWF)NY2\n" +
                "2WN)WK1\n" +
                "X5D)N6T\n" +
                "96L)QL4\n" +
                "J4K)J1X\n" +
                "G2S)S6W\n" +
                "GL3)S3K\n" +
                "3WL)2Z7\n" +
                "RHQ)GJL\n" +
                "C1G)GYW\n" +
                "CSW)VT8\n" +
                "ZKS)L3B\n" +
                "ZZN)YNG\n" +
                "3LX)DGG\n" +
                "HLN)N48\n" +
                "F64)574\n" +
                "ZGP)DXV\n" +
                "1M8)ZH1\n" +
                "YM5)L5Y\n" +
                "GDV)NX5\n" +
                "MQW)1T3\n" +
                "1KP)W84\n" +
                "DG9)K2W\n" +
                "6RH)BD7\n" +
                "FLK)CR5\n" +
                "FHB)7ZK\n" +
                "LD2)ZV5\n" +
                "XKR)JC2\n" +
                "GDG)5WV\n" +
                "Y9C)PYS\n" +
                "L27)GGQ\n" +
                "GYW)HS1\n" +
                "679)SXV\n" +
                "2VS)8QY\n" +
                "72G)XJK\n" +
                "RJB)8N4\n" +
                "3MK)WWF\n" +
                "MTK)F2W\n" +
                "HTM)LGN\n" +
                "RXP)7JT\n" +
                "X28)6Z7\n" +
                "GY1)Z8Y\n" +
                "MMX)WP3\n" +
                "3ZJ)FRB\n" +
                "735)2NM\n" +
                "1D6)8X8\n" +
                "TN9)4ZC\n" +
                "DPV)739\n" +
                "7PS)XPX\n" +
                "PPJ)BXZ\n" +
                "JW5)M5D\n" +
                "ZDD)1JD\n" +
                "1Y5)ZVQ\n" +
                "SJ8)45K\n" +
                "3ZQ)RYQ\n" +
                "43J)JK5\n" +
                "MFX)2TT\n" +
                "Z67)ZKS\n" +
                "D2G)HK2\n" +
                "GX8)5RM\n" +
                "M11)GNK\n" +
                "W7T)NJK\n" +
                "771)5VT\n" +
                "G2F)3R2\n" +
                "Y1Y)D8S\n" +
                "C3G)S63\n" +
                "B5N)8Y4\n" +
                "BGY)KPN\n" +
                "GK9)6K1\n" +
                "Y7L)H2B\n" +
                "CQL)DPV\n" +
                "F2K)TQC\n" +
                "38J)LSY\n" +
                "YVR)GB5\n" +
                "M1Z)H2Q\n" +
                "FCJ)3YL\n" +
                "P22)8KX\n" +
                "1TS)F5F\n" +
                "QL4)W92\n" +
                "CG5)D41\n" +
                "MKY)WVJ\n" +
                "H2Q)1BM\n" +
                "DCD)PDC\n" +
                "3JT)47T\n" +
                "GQ6)RP1\n" +
                "Y93)GCS\n" +
                "NMP)76S\n" +
                "3NF)YYM\n" +
                "PHQ)4QF\n" +
                "DR8)JXJ\n" +
                "64F)5B8\n" +
                "BFL)PHQ\n" +
                "44S)8FS\n" +
                "85N)5SF\n" +
                "JLG)MSF\n" +
                "3BJ)L96\n" +
                "DGG)GDG\n" +
                "CLM)TGT\n" +
                "J7L)TLW\n" +
                "HT4)7XC\n" +
                "WMV)SNQ\n" +
                "KZ3)9CC\n" +
                "G6T)X81\n" +
                "HFT)4WW\n" +
                "VQB)HVR\n" +
                "GGM)JGV\n" +
                "KX6)SCZ\n" +
                "561)6N9\n" +
                "NDH)BVT\n" +
                "DFG)PRL\n" +
                "NP6)3ZQ\n" +
                "1MQ)MKY\n" +
                "X81)1BH\n" +
                "G55)HS6\n" +
                "4ZX)CQW\n" +
                "62Y)9L7\n" +
                "D6B)6XK\n" +
                "2SH)63H\n" +
                "K2W)3HF\n" +
                "QQL)N51\n" +
                "WZB)5YM\n" +
                "TJF)6RH\n" +
                "G11)348\n" +
                "8YK)Y23\n" +
                "KYK)W67\n" +
                "JGY)77D\n" +
                "HM5)HFY\n" +
                "VY5)DP5\n" +
                "QCL)67G\n" +
                "J7F)7X9\n" +
                "LMK)68W\n" +
                "CXP)62Y\n" +
                "311)6PB\n" +
                "JTX)SAN\n" +
                "P8Q)7HF\n" +
                "1S9)FHL\n" +
                "48J)QCJ\n" +
                "KH6)D91\n" +
                "858)RB3\n" +
                "95Z)C9W\n" +
                "VS1)9DX\n" +
                "Y12)21L\n" +
                "CZB)TKK\n" +
                "Q4P)PXH\n" +
                "GBD)QCL\n" +
                "PXH)TQN\n" +
                "4X3)KW8\n" +
                "RXP)XYT\n" +
                "7VW)1CW\n" +
                "5PG)LVW\n" +
                "KJY)QYZ\n" +
                "MRM)QL1\n" +
                "KN7)3HP\n" +
                "JB6)C3G\n" +
                "H2H)7VW\n" +
                "4F6)TKF\n" +
                "D23)9KH\n" +
                "B6X)1M6\n" +
                "KLJ)2N6\n" +
                "NMN)8ZR\n" +
                "QTZ)SDR\n" +
                "C3G)43P\n" +
                "BRB)FKC\n" +
                "9PQ)BR7\n" +
                "PDC)QCG\n" +
                "KRB)524\n" +
                "Z5M)WP1\n" +
                "K17)5VG\n" +
                "XNL)NCT\n" +
                "26V)C9X\n" +
                "9YR)26Q\n" +
                "QLH)RPD\n" +
                "5VT)FZQ\n" +
                "C9X)BR9\n" +
                "M5D)SVP\n" +
                "NY2)8PF\n" +
                "ZZC)YCZ\n" +
                "Y23)GDP\n" +
                "LR5)855\n" +
                "1CV)J7F\n" +
                "LV7)VS1\n" +
                "783)CG5\n" +
                "ZSL)3WH\n" +
                "L91)1KP\n" +
                "DVX)TYV\n" +
                "SDH)D6F\n" +
                "Y2T)WFB\n" +
                "5K5)NSM\n" +
                "G61)ML1\n" +
                "HM6)Z5M\n" +
                "M11)HTM\n" +
                "XSK)LMK\n" +
                "XJP)45H\n" +
                "L46)WS5\n" +
                "45C)G1K\n" +
                "1SJ)KNS\n" +
                "BC1)HCS\n" +
                "DHH)26V\n" +
                "GV8)CHZ\n" +
                "9F3)HVV\n" +
                "YCS)L27\n" +
                "BXZ)WZB\n" +
                "VF8)NV7\n" +
                "2ZC)75W\n" +
                "9YT)LD2\n" +
                "QMC)TNH\n" +
                "BZ6)B11\n" +
                "HKM)ZKK\n" +
                "CTL)WRS\n" +
                "MKK)697\n" +
                "TYV)GRQ\n" +
                "XS1)L79\n" +
                "5G2)XSG\n" +
                "1BM)44S\n" +
                "X7V)TN9\n" +
                "NGQ)DN1\n" +
                "HT9)VMT\n" +
                "RB3)8BS\n" +
                "SKN)6QL\n" +
                "ZL3)NVX\n" +
                "GDP)WTF\n" +
                "2YY)KZ3\n" +
                "WDD)Q2R\n" +
                "TW9)ZCY\n" +
                "QTV)128\n" +
                "J27)HNX\n" +
                "77D)GQN\n" +
                "52R)YVJ\n" +
                "VY9)ZHB\n" +
                "JSX)HM5\n" +
                "MV8)KDD\n" +
                "Y88)BWH\n" +
                "2DG)K52\n" +
                "ZVQ)3YV\n" +
                "PTT)BDF\n" +
                "75W)ZZN\n" +
                "RYQ)Z5Z\n" +
                "G1K)VSM\n" +
                "WRS)DFG\n" +
                "34B)FLW\n" +
                "95R)T4W\n" +
                "6X1)DHH\n" +
                "FGP)FPK\n" +
                "L1V)RKS\n" +
                "36G)5K5\n" +
                "Z8Y)6WR\n" +
                "6Z2)D2G\n" +
                "X3G)TLN\n" +
                "4N7)DRC\n" +
                "SKY)S2S\n" +
                "2HT)DCC\n" +
                "X78)YRX\n" +
                "L7P)1DM\n" +
                "2NG)BTG\n" +
                "97R)1D3\n" +
                "KW8)5HN\n" +
                "ZNT)WMF\n" +
                "Y2F)2Z1\n" +
                "FZQ)28L\n" +
                "WZX)Q9J\n" +
                "CQX)GBD\n" +
                "LKM)KS8\n" +
                "QL4)CMQ\n" +
                "T77)J92\n" +
                "WMR)556\n" +
                "TYH)LTV\n" +
                "Z99)D6B\n" +
                "FKT)8F9\n" +
                "JQY)QMR\n" +
                "3WH)NXV\n" +
                "WMF)V41\n" +
                "GQ5)QTN\n" +
                "N5M)MKM\n" +
                "RGG)BV3\n" +
                "7Q5)S4C\n" +
                "7HX)R9R\n" +
                "FC8)FRL\n" +
                "MJY)F9D\n" +
                "4D7)F2K\n" +
                "348)DC2\n" +
                "JVR)D1M\n" +
                "K6F)DL1\n" +
                "M99)YOU\n" +
                "8PF)SYQ\n" +
                "L79)FQV\n" +
                "M9L)HJW\n" +
                "FHL)NP6\n" +
                "J4F)7PS\n" +
                "XSK)TC3\n" +
                "KZZ)Z75\n" +
                "VHV)6YF\n" +
                "6QN)52R\n" +
                "BCZ)Z9K\n" +
                "6Q6)5FQ\n" +
                "J6N)DS9\n" +
                "XF2)CCF\n" +
                "C9W)WFD\n" +
                "DCX)B49\n" +
                "GNK)9SM\n" +
                "KW8)TDX\n" +
                "3M1)LH8\n" +
                "KT1)3SF\n" +
                "YK5)16V\n" +
                "9SM)2LT\n" +
                "VF4)SDH\n" +
                "HSH)YCS\n" +
                "RKS)5G5\n" +
                "TDX)7JZ\n" +
                "9CM)2CF\n" +
                "K9H)2KW\n" +
                "3HD)RXP\n" +
                "CQL)FRF\n" +
                "6N7)MMX\n" +
                "JB6)37Z\n" +
                "J2B)FTZ\n" +
                "9RD)49H\n" +
                "3HP)L1V\n" +
                "P4W)CZB\n" +
                "1Y5)FYT\n" +
                "2H1)ZRQ\n" +
                "JH7)6LF\n" +
                "DXM)RG9\n" +
                "X6T)BZ6\n" +
                "69H)GV8\n" +
                "XQ7)Z7R\n" +
                "5NP)QD9\n" +
                "JTH)4L5\n" +
                "FTC)LLY\n" +
                "LT9)PWD\n" +
                "739)SP2\n" +
                "ZZF)DF6\n" +
                "9V6)Q96\n" +
                "R28)4PR\n" +
                "C5H)GHW\n" +
                "7HF)DTY\n" +
                "49P)J27\n" +
                "2LT)CFC\n" +
                "HQQ)JCS\n" +
                "F1G)NVG\n" +
                "JXJ)65C\n" +
                "W7Z)B7D\n" +
                "Q8T)VK6\n" +
                "83Q)CXW\n" +
                "7XC)XQ7\n" +
                "S4H)KM9\n" +
                "5TD)R7R\n" +
                "45P)T83\n" +
                "TC3)ZX5\n" +
                "8N5)61Q\n" +
                "HTN)JRK\n" +
                "W2D)NRH\n" +
                "CB6)9H4\n" +
                "HVV)73D\n" +
                "B82)DR8\n" +
                "9R9)GT5\n" +
                "X2F)GT4\n" +
                "D6F)XDN\n" +
                "DBJ)KH6\n" +
                "Y7N)1F3\n" +
                "SY4)X28\n" +
                "N48)29W\n" +
                "735)JN4\n" +
                "SJC)19S\n" +
                "M25)BP1\n" +
                "HK2)5D4\n" +
                "3R2)7PM\n" +
                "Z9K)YSD\n" +
                "YCM)W1F\n" +
                "JJB)KN7\n" +
                "3TR)36D\n" +
                "48C)RM5\n" +
                "L27)JV6\n" +
                "BD7)CLM\n" +
                "D47)ZWB\n" +
                "R3B)2CP\n" +
                "FMW)4ZX\n" +
                "FPK)JRR\n" +
                "H6C)NMR\n" +
                "HJW)P8Q\n" +
                "5G5)KKR\n" +
                "W84)ZSL\n" +
                "K95)CT6\n" +
                "HQC)JRB\n" +
                "LSG)J7L\n" +
                "5GF)KXF\n" +
                "R2G)95Z\n" +
                "62Q)45P\n" +
                "Q2R)W66\n" +
                "9F3)Q2T\n" +
                "969)XPV\n" +
                "H8S)CM3\n" +
                "G2S)X3R\n" +
                "WS5)XC1\n" +
                "CDS)F4K\n" +
                "TZT)W7W\n" +
                "6LF)9SY\n" +
                "5HN)992\n" +
                "HCS)M1Z\n" +
                "GK9)XKR\n" +
                "BMY)G6T\n" +
                "RHQ)23M\n" +
                "PYK)TXD\n" +
                "VNL)6Z2\n" +
                "7R6)QTV\n" +
                "HVJ)6Z5\n" +
                "S63)HJ6\n" +
                "CWD)CQX\n" +
                "R4V)TV1\n" +
                "4VM)8YK\n" +
                "W9K)J6N\n" +
                "28M)586\n" +
                "TKF)P21\n" +
                "PSD)758\n" +
                "5MP)265\n" +
                "VYB)FBM\n" +
                "SKD)Z3T\n" +
                "7KY)YR3\n" +
                "FYT)9VS\n" +
                "PG8)47W\n" +
                "RDS)CHS\n" +
                "LJH)F4H\n" +
                "8N9)MZD\n" +
                "F9D)3GR\n" +
                "4GC)G7Y\n" +
                "272)Z67\n" +
                "DZK)X54\n" +
                "NRH)ZHF\n" +
                "FF8)LD9\n" +
                "WVQ)R2N\n" +
                "JRK)DG9\n" +
                "6WR)WVQ\n" +
                "J27)JDW\n" +
                "B14)WMV\n" +
                "W7W)QM9\n" +
                "D1M)C38\n" +
                "SRP)RHQ\n" +
                "T1M)S7Q\n" +
                "RYX)Q4B\n" +
                "WJP)T78\n" +
                "48C)BCX\n" +
                "892)JKR\n" +
                "SZ8)48J\n" +
                "DL1)4X3\n" +
                "JCS)G11\n" +
                "KS8)827\n" +
                "1TD)65N\n" +
                "FLL)7YX\n" +
                "65N)783\n" +
                "CNN)5G2\n" +
                "586)311\n" +
                "4SX)8N9\n" +
                "9KH)C8Q\n" +
                "JJB)CQL\n" +
                "YMQ)754\n" +
                "5RC)7R6\n" +
                "ZWB)96L\n" +
                "XSG)3JP\n" +
                "T82)T8Z\n" +
                "ZYJ)K9H\n" +
                "WDD)G55\n" +
                "YC5)9YL\n" +
                "2CK)86G\n" +
                "JN6)3HD\n" +
                "MTK)GGR\n" +
                "KSF)3HY\n" +
                "67G)6KX\n" +
                "DST)KRK\n" +
                "VJH)F51\n" +
                "VMT)99Z\n" +
                "4JG)DLS\n" +
                "TLW)WQB\n" +
                "PWK)PPJ\n" +
                "YMD)ZV9\n" +
                "FRL)FXY\n" +
                "TF9)7Y8\n" +
                "R1R)M79\n" +
                "98G)JWQ\n" +
                "8XM)5GF\n" +
                "TXD)MXZ\n" +
                "MSQ)9NN\n" +
                "4PR)H2H\n" +
                "NVG)PH4\n" +
                "QL1)XMW\n" +
                "MB5)MYV\n" +
                "5XZ)PK7\n" +
                "M79)3V2\n" +
                "PXM)1QP\n" +
                "3HF)XS1\n" +
                "4WW)B5N\n" +
                "6MZ)N5M\n" +
                "B5N)Y2F\n" +
                "TQC)FS9\n" +
                "5YM)TMV\n" +
                "LMN)W3X\n" +
                "RBB)5NP\n" +
                "9VS)CW3\n" +
                "2ZQ)KXV\n" +
                "J7F)NYK\n" +
                "2VM)6JV\n" +
                "2TS)1MQ\n" +
                "NV7)CSW\n" +
                "3JT)FGP\n" +
                "T78)YVR\n" +
                "WV9)YMQ\n" +
                "6JV)2SH\n" +
                "W57)Y2T\n" +
                "L9V)223\n" +
                "F2W)GL3\n" +
                "HVR)RGG\n" +
                "PSP)VY5\n" +
                "7WP)PWR\n" +
                "SYQ)9V6\n" +
                "9YL)6SR\n" +
                "NX7)V66\n" +
                "D4B)RBB\n" +
                "1K4)TBY\n" +
                "X54)ZRK\n" +
                "CM3)6BV\n" +
                "73D)5RC\n" +
                "D91)5C8\n" +
                "6VD)FTC\n" +
                "VTH)C17\n" +
                "SVP)CXL\n" +
                "HQ1)TZ2\n" +
                "TMV)WDD\n" +
                "RM5)DTQ\n" +
                "T8Z)PW8\n" +
                "R85)5WR\n" +
                "7ZK)SQT\n" +
                "5X8)DT1\n" +
                "FTZ)TKL\n" +
                "45K)97R\n" +
                "RPD)RY1\n" +
                "CGT)T3W\n" +
                "TNH)1CR\n" +
                "H2B)TVN\n" +
                "5F4)5VX\n" +
                "MJG)YTZ\n" +
                "J8R)LL7\n" +
                "85X)C6Z\n" +
                "6BV)BRB\n" +
                "YCZ)D3V\n" +
                "56X)ZZC\n" +
                "697)C74\n" +
                "H8S)MKK\n" +
                "9YL)G6S\n" +
                "FLW)NJS\n" +
                "DT1)5Y2";


        HashMap<String,String> orbitMap = new HashMap<>();

        int count = 0;

        List<String> maps = Arrays.asList(data.split("\n"));
        for (String map: maps) {
            String orbiter = map.split("\\)")[1];
            String orbitee = map.split("\\)")[0];
            orbitMap.put(orbiter,orbitee);
            System.out.println("orbitee: "+orbitee+" orbiter: "+orbiter);
        }

        for (String map: maps) {
            String orbiter = map.split("\\)")[1];
            String orbitee = orbiter;
            while(!orbiter.equals("COM")){
                orbiter = orbitMap.get(orbiter);
                count++;
            }

        }
        System.out.println("count: "+count);

        String youPointer="YOU";
        String santaPointer="SAN";
        HashMap<String, Integer> youPath = new HashMap<>();
        HashMap<String, Integer> santaPath = new HashMap<>();

        String orbiter = youPointer;
        count=0;
        while(!orbiter.equals("COM")){
            orbiter = orbitMap.get(orbiter);
            count++;
            youPath.put(orbiter,count);
            System.out.println("You path: "+orbiter+" "+count);
        }

        orbiter  = santaPointer;
        count=0;
        while(!orbiter.equals("COM")){
            orbiter = orbitMap.get(orbiter);
            count++;
            if(youPath.containsKey(orbiter)) {
                 count = count + youPath.get(orbiter);
                break;
            }

        }
        System.out.println("Path to santa count: " + (count - 2));



    }


}
