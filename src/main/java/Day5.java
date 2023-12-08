package main.java;

import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        long[] seeds = Arrays.stream(SEEDS.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        List<SrcDstRange> seedToSoil = generateMap(SEED_TO_SOIL);
        List<SrcDstRange> soilToFertilizer = generateMap(SOIL_TO_FERTILIZER);
        List<SrcDstRange> fertilizerToWater = generateMap(FERTILIZER_TO_WATER);
        List<SrcDstRange> waterToLight = generateMap(WATER_TO_LIGHT);
        List<SrcDstRange> lightToTemp = generateMap(LIGHT_TO_TEMP);
        List<SrcDstRange> tempToHumidity = generateMap(TEMP_TO_HUMIDITY);
        List<SrcDstRange> humidityToLocation = generateMap(HUMIDITY_TO_LOCATION);

        long shortestLocation = Long.MAX_VALUE;
        for (long seed : seeds) {
            long soil = srcToDst(seedToSoil, seed);
            long fertilizer = srcToDst(soilToFertilizer, soil);
            long water = srcToDst(fertilizerToWater, fertilizer);
            long light = srcToDst(waterToLight, water);
            long temp = srcToDst(lightToTemp, light);
            long humidity = srcToDst(tempToHumidity, temp);
            long location = srcToDst(humidityToLocation, humidity);
            if (location < shortestLocation) shortestLocation = location;
        }
        System.out.println("Shortest location: " + shortestLocation);
    }

    private static void part2Example() {
        long[] seedRanges = Arrays.stream(EXAMPLE_SEEDS.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long shortestLocation = Long.MAX_VALUE;
        List<SrcDstRange> seedToSoil = generateMap(EXAMPLE_SEED_TO_SOIL);
        List<SrcDstRange> soilToFertilizer = generateMap(EXAMPLE_SOIL_TO_FERTILIZER);
        List<SrcDstRange> fertilizerToWater = generateMap(EXAMPLE_FERTILIZER_TO_WATER);
        List<SrcDstRange> waterToLight = generateMap(EXAMPLE_WATER_TO_LIGHT);
        List<SrcDstRange> lightToTemp = generateMap(EXAMPLE_LIGHT_TO_TEMP);
        List<SrcDstRange> tempToHumidity = generateMap(EXAMPLE_TEMP_TO_HUMIDITY);
        List<SrcDstRange> humidityToLocation = generateMap(EXAMPLE_HUMIDITY_TO_LOCATION);
        for (int i = 0; i < seedRanges.length; i = i + 2) {
            long start = seedRanges[i];
            long range = seedRanges[i + 1];
            for (long seed = start; seed < start + range; seed++) {
                    long soil = srcToDst(seedToSoil, seed);
                    long fertilizer = srcToDst(soilToFertilizer, soil);
                    long water = srcToDst(fertilizerToWater, fertilizer);
                    long light = srcToDst(waterToLight, water);
                    long temp = srcToDst(lightToTemp, light);
                    long humidity = srcToDst(tempToHumidity, temp);
                    long location = srcToDst(humidityToLocation, humidity);
                    if (location < shortestLocation) shortestLocation = location;
                }
            }
        System.out.println("Shortest location: " + shortestLocation);
    }

    private static void part2() {
        long[] seedRanges = Arrays.stream(SEEDS.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long shortestLocation = Long.MAX_VALUE;
        List<SrcDstRange> seedToSoil = generateMap(SEED_TO_SOIL);
        List<SrcDstRange> soilToFertilizer = generateMap(SOIL_TO_FERTILIZER);
        List<SrcDstRange> fertilizerToWater = generateMap(FERTILIZER_TO_WATER);
        List<SrcDstRange> waterToLight = generateMap(WATER_TO_LIGHT);
        List<SrcDstRange> lightToTemp = generateMap(LIGHT_TO_TEMP);
        List<SrcDstRange> tempToHumidity = generateMap(TEMP_TO_HUMIDITY);
        List<SrcDstRange> humidityToLocation = generateMap(HUMIDITY_TO_LOCATION);
        for (int i = 0; i < seedRanges.length; i = i + 2) {
            long start = seedRanges[i];
            long range = seedRanges[i + 1];
            for (long seed = start; seed < start + range; seed++) {
                    long soil = srcToDst(seedToSoil, seed);
                    long fertilizer = srcToDst(soilToFertilizer, soil);
                    long water = srcToDst(fertilizerToWater, fertilizer);
                    long light = srcToDst(waterToLight, water);
                    long temp = srcToDst(lightToTemp, light);
                    long humidity = srcToDst(tempToHumidity, temp);
                    long location = srcToDst(humidityToLocation, humidity);
                    if (location < shortestLocation) shortestLocation = location;
                }
            }
        System.out.println("Shortest location2: " + shortestLocation);
    }

    private static long srcToDst(List<SrcDstRange> srcDstRanges, long src) {
        if (src < srcDstRanges.get(0).src) {
            return src;
        }
        for (SrcDstRange sdr : srcDstRanges) {
//            long srcStart = sdr.src;
//            long srcEnd = sdr.src + sdr.range;
            if (src >= sdr.src && src < sdr.src+sdr.range) {
                long diff = src - sdr.src;
                return sdr.dst + diff;
            }
        }
        return src;
    }

    record SrcDstRange(long src, long dst, long range) { }


    private static List<SrcDstRange> generateMap(String mapString) {
        List<SrcDstRange> list = new ArrayList<>();
        for (String line : mapString.split("\n")) {
            String[] nums = line.split(" ");
            long dst = Long.parseLong(nums[0]);
            long src = Long.parseLong(nums[1]);
            long range = Long.parseLong(nums[2]);
            list.add(new SrcDstRange(src, dst, range));
        }
        return list.stream().sorted(Comparator.comparingLong(a -> a.src)).toList();
    }

    private static final String EXAMPLE_SEEDS = "79 14 55 13";
    private static final String EXAMPLE_SEED_TO_SOIL = "50 98 2\n" +
            "52 50 48";
    private static final String EXAMPLE_SOIL_TO_FERTILIZER = "0 15 37\n" +
            "37 52 2\n" +
            "39 0 15";
    private static final String EXAMPLE_FERTILIZER_TO_WATER = "49 53 8\n" +
            "0 11 42\n" +
            "42 0 7\n" +
            "57 7 4";
    private static final String EXAMPLE_WATER_TO_LIGHT = "88 18 7\n" +
            "18 25 70";
    private static final String EXAMPLE_LIGHT_TO_TEMP = "45 77 23\n" +
            "81 45 19\n" +
            "68 64 13";
    private static final String EXAMPLE_TEMP_TO_HUMIDITY = "0 69 1\n" +
            "1 0 69";
    private static final String EXAMPLE_HUMIDITY_TO_LOCATION = "60 56 37\n" +
            "56 93 4";
    private static final String SEEDS = "4043382508 113348245 3817519559 177922221 3613573568 7600537 773371046 400582097 2054637767 162982133 2246524522 153824596 1662955672 121419555 2473628355 846370595 1830497666 190544464 230006436 483872831";

    private static final String SEED_TO_SOIL = "" +
            "4064811 506246814 25615317\n" +
            "1520011681 1661018909 106057083\n" +
            "1007960598 8836276 47579700\n" +
            "1055540298 679332386 82196064\n" +
            "2377475243 3574057730 33434621\n" +
            "2323567163 2090355001 53908080\n" +
            "2724594670 4209189177 35645909\n" +
            "3247614896 4244835086 50132210\n" +
            "2793935335 3209861711 43002393\n" +
            "2560156404 2081665194 8689807\n" +
            "3490249256 2918928471 290933240\n" +
            "1399066513 1515349965 120856915\n" +
            "3383052312 1779636204 107196944\n" +
            "1634905040 1464437422 50912543\n" +
            "0 849557294 4064811\n" +
            "2155322314 2548120606 2883579\n" +
            "3362202103 2803876083 20850209\n" +
            "465575436 853622105 310104399\n" +
            "3781182496 3252864104 5074346\n" +
            "3297747106 3844665588 64454997\n" +
            "1779636204 2144263081 375686110\n" +
            "2765805312 2519990583 28130023\n" +
            "1325393680 605659553 73672833\n" +
            "1211533784 841842038 7715256\n" +
            "164952771 1163726504 300622665\n" +
            "2197289480 3607492351 121111676\n" +
            "54492157 395786200 110460614\n" +
            "3835840979 3257938450 316119280\n" +
            "1685817583 162560616 944821\n" +
            "1626068764 0 8836276\n" +
            "2760240579 3728604027 5564733\n" +
            "1219249040 56415976 106144640\n" +
            "2836937728 3734168760 105330821\n" +
            "2994742998 2551004185 252871898\n" +
            "4246162438 3909120585 48804858\n" +
            "775679835 163505437 232280763\n" +
            "2410909864 3957925443 149246540\n" +
            "3786256842 4107171983 49584137\n" +
            "2158205893 1886833148 39083587\n" +
            "29680128 1636206880 24812029\n" +
            "2994701606 2519949191 41392\n" +
            "1137736362 531862131 73797422\n" +
            "1686762404 761528450 80313588\n" +
            "2942268549 4156756120 52433057\n" +
            "1519923428 1464349169 88253\n" +
            "4151960259 2824726292 94202179\n" +
            "2568846211 1925916735 155748459\n" +
            "2318401156 3839499581 5166007";
        private static final String SOIL_TO_FERTILIZER = "" +
            "664927065 1834026871 25712908\n" +
            "1735589252 664927065 98272608\n" +
            "2065221534 1506193032 310617880\n" +
            "2375839414 4115277554 6678312\n" +
            "3253816560 1859739779 203737617\n" +
            "1850812956 4108908733 6368821\n" +
            "2919962848 2399006039 522616\n" +
            "468677210 108672893 44408648\n" +
            "1401161152 2664100077 99602261\n" +
            "1500763413 2164180200 234825839\n" +
            "3984134761 1144008481 310832535\n" +
            "3804009398 3016674464 2139313\n" +
            "963394967 763199673 148819056\n" +
            "2382517726 2954526136 62148328\n" +
            "2596720874 2399528655 264571422\n" +
            "1112214023 3018813777 288947129\n" +
            "1874397736 2763702338 190823798\n" +
            "2920485464 4108473866 434867\n" +
            "2496018070 2063477396 100702804\n" +
            "3824353112 3447611199 78601908\n" +
            "690639973 3526213107 99743564\n" +
            "3806148711 928969825 18204401\n" +
            "2861292296 3388940647 58670552\n" +
            "0 356321399 298014179\n" +
            "3902955020 3307760906 81179741\n" +
            "360004317 0 108672893\n" +
            "790383537 4121955866 173011430\n" +
            "3457554177 3762018645 346455221\n" +
            "1833861860 912018729 16951096\n" +
            "3056982305 947174226 131597944\n" +
            "2444666054 1454841016 51352016\n" +
            "3188580249 1078772170 65236311\n" +
            "513085858 153081541 141249720\n" +
            "1857181777 1816810912 17215959\n" +
            "298014179 294331261 61990138\n" +
            "2920920331 3625956671 136061974";
    private static final String FERTILIZER_TO_WATER = "" +
            "1314722794 2859771596 110470422\n" +
            "925980570 2089240080 7623550\n" +
            "2161966099 923823182 18764610\n" +
            "4126382841 3495278690 168584455\n" +
            "1914851626 1547043780 6792197\n" +
            "3603209919 3780725227 292923781\n" +
            "2451774221 919021074 4802108\n" +
            "3495278690 4073649008 66625331\n" +
            "3896133700 3663863145 116862082\n" +
            "2180730709 506275893 271043512\n" +
            "3141265861 2645889920 57381085\n" +
            "3136392798 1603951687 4873063\n" +
            "1538199090 942587792 376652536\n" +
            "620357722 2970242018 228404928\n" +
            "422454208 1814118646 197903514\n" +
            "1921643823 265953617 240322276\n" +
            "3561904021 4140274339 41305898\n" +
            "2758272184 2474071507 63802901\n" +
            "1065005613 777319405 141701669\n" +
            "4012995782 4181580237 113387059\n" +
            "2822075085 1553835977 50115710\n" +
            "1425193216 2361065633 113005874\n" +
            "933604120 1682717153 131401493\n" +
            "1206707282 2537874408 108015512\n" +
            "2872190795 2096863630 264202003\n" +
            "2684379781 1608824750 73892403\n" +
            "0 2703271005 156500591\n" +
            "156500591 0 265953617\n" +
            "2456576329 1319240328 227803452\n" +
            "848762650 2012022160 77217920";
    private static final String WATER_TO_LIGHT = "" +
            "3911747472 2911922447 51421887\n" +
            "2536764367 3668005785 140896771\n" +
            "1212477776 97723896 242971514\n" +
            "3654733164 2831217728 80704719\n" +
            "2181820500 1577059176 179170851\n" +
            "1585336302 2992871942 130403154\n" +
            "3625205556 2963344334 29527608\n" +
            "637624684 802080725 399476166\n" +
            "3348594580 2554606752 276610976\n" +
            "2677661138 1756230027 290805772\n" +
            "1715739456 3808902556 44864370\n" +
            "1760603826 3853766926 127009556\n" +
            "263054927 0 97723896\n" +
            "3735437883 3980776482 176309589\n" +
            "2052216401 4165363197 129604099\n" +
            "3963169359 2047035799 96879299\n" +
            "1037100850 340695410 175376926\n" +
            "2968466910 3287878115 380127670\n" +
            "4292066496 2319688114 2900800\n" +
            "360778823 516072336 276845861\n" +
            "1577059176 4157086071 8277126\n" +
            "0 1201556891 263054927\n" +
            "2360991351 2143915098 175773016\n" +
            "1455449290 792918197 9162528\n" +
            "1887613382 3123275096 164603019\n" +
            "4060048658 2322588914 232017838";
    private static final String LIGHT_TO_TEMP = "" +
            "2208796188 2205653945 16706445\n" +
            "3202718202 3702799517 119048394\n" +
            "1789679483 2433538636 64618493\n" +
            "3035078142 2303892266 86108184\n" +
            "2549270997 3861079544 160369770\n" +
            "1016521015 833146166 1531563\n" +
            "2446163080 1924420264 78302216\n" +
            "3321766596 2112712346 92941599\n" +
            "8948937 233013740 2442944\n" +
            "1900324808 3247280742 118974530\n" +
            "215056009 134795275 63846376\n" +
            "3929651545 3821847911 39231633\n" +
            "3841595991 3463600348 88055554\n" +
            "3968883178 1812769444 68270872\n" +
            "2709640767 1707931127 104838317\n" +
            "1494154584 2498157129 295524899\n" +
            "0 1122900024 8948937\n" +
            "4037154050 1450117881 257813246\n" +
            "2814479084 2793682028 220599058\n" +
            "3121186326 2222360390 81531876\n" +
            "3568078009 4021449314 273517982\n" +
            "393292224 0 134795275\n" +
            "1251655629 2390000450 43538186\n" +
            "2154776907 3193261461 54019281\n" +
            "1854297976 1447593855 2524026\n" +
            "1153492607 3551655902 98163022\n" +
            "2019299338 3057783892 135477569\n" +
            "93266807 850231816 121789202\n" +
            "2225502633 3649818924 52980593\n" +
            "377738137 834677729 15554087\n" +
            "361270479 972021018 16467658\n" +
            "1018052578 988488676 113796383\n" +
            "72651842 1102285059 20614965\n" +
            "3458088143 2002722480 109989866\n" +
            "326898390 198641651 34372089\n" +
            "1295193815 1248633086 198960769\n" +
            "2278483226 3366255272 97345076\n" +
            "2375828302 1153492607 70334778\n" +
            "1856822002 3014281086 43502806\n" +
            "278902385 235456684 47996005\n" +
            "2524465296 1223827385 24805701\n" +
            "11391881 283452689 61259961\n" +
            "528087499 344712650 488433516\n" +
            "3414708195 1881040316 43379948";
    private static final String TEMP_TO_HUMIDITY = "" +
            "1719782869 425080238 132898807\n" +
            "1852681676 2807250453 270691921\n" +
            "1309417343 2396884927 410365526\n" +
            "963471708 0 345945635\n" +
            "2998807771 345945635 79134603\n" +
            "2123373597 557979045 875434174\n" +
            "0 1433413219 963471708\n";
    private static final String HUMIDITY_TO_LOCATION = "" +
            "3506221501 3772218811 141412231\n" +
            "862456464 199991593 70194315\n" +
            "3126163959 2720338622 159394827\n" +
            "2437060415 0 153033469\n" +
            "1749227774 1174286868 159521600\n" +
            "349850270 652576354 37663076\n" +
            "158202776 305209374 55106503\n" +
            "663092217 153033469 46958124\n" +
            "1358475419 819305682 231265535\n" +
            "1589740954 2171223218 159486820\n" +
            "1296848852 450545479 26971073\n" +
            "213309279 2375483203 136540991\n" +
            "501031877 1333808468 54731739\n" +
            "2272970697 690239430 129066252\n" +
            "427251734 1050571217 73780143\n" +
            "1918845890 1626226842 116689237\n" +
            "3494757929 2708875050 11463572\n" +
            "2781047724 3224629140 67922856\n" +
            "3442916224 4132386344 51841705\n" +
            "932650779 1388540207 237686635\n" +
            "387513346 1742916079 39738388\n" +
            "3866389034 3340362984 418348873\n" +
            "710050341 587492729 57697450\n" +
            "3342406366 4184228049 100509858\n" +
            "0 360315877 90229602\n" +
            "812520956 1124351360 49935508\n" +
            "2162994520 477516552 109976177\n" +
            "2035535127 1901779730 127459393\n" +
            "2719729782 3758711857 13506954\n" +
            "2733236736 3292551996 47810988\n" +
            "2652027470 3156926828 67702312\n" +
            "767747791 2330710038 44773165\n" +
            "2848970580 2879733449 277193379\n" +
            "1170337414 645190179 7386175\n" +
            "1177723589 1782654467 119125263\n" +
            "3285558786 2652027470 56847580\n" +
            "1323819925 2136567724 34655494\n" +
            "1908749374 2512024194 10096516\n" +
            "3647633732 3913631042 218755302\n" +
            "555763616 2029239123 107328601\n" +
            "2402036949 270185908 35023466\n" +
            "90229602 2522120710 67973174";
}
