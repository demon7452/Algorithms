package org.hacker.week7;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        String rankStr = "998 995 995 991 989 989 984 979 968 964 955 955 947 945 942 934 933 930 928 927 918 916 905 900 898 895 895 895 892 887 882 881 878 876 872 872 858 856 846 844 839 823 808 806 804 800 799 794 793 789 784 772 766 765 764 762 762 759 757 751 747 745 738 725 720 708 706 703 699 697 693 691 690 685 682 677 662 661 656 648 642 641 640 634 632 625 623 618 618 617 601 601 600 591 585 583 578 552 550 550 546 543 539 509 505 503 503 494 486 474 472 472 472 468 467 464 439 438 434 434 427 421 420 405 399 395 392 388 386 384 377 374 368 356 350 344 342 341 337 331 298 296 296 294 290 260 259 248 245 244 244 233 228 215 211 210 206 202 201 189 186 181 178 168 163 162 161 159 151 147 143 142 142 141 139 132 130 128 125 125 120 112 111 95 92 91 88 81 69 66 63 48 44 20 18 17 14 8 1 1";
        String[] rankArray = rankStr.split(" ");
        List<Integer> ranked = new ArrayList<>(200);
        for (String rank : rankArray) {
            ranked.add(Integer.parseInt(rank));
        }

        String playerStr = "18 31 38 126 152 170 198 199 202 243 369 376 376 408 560 572 614 665 666 942";
        String[] playerArray = playerStr.split(" ");
        List<Integer> player = new ArrayList<>(20);
        for (String rank : playerArray) {
            player.add(Integer.parseInt(rank));
        }

//        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
//        List<Integer> player = Arrays.asList(5, 15, 25, 50, 120, 99);
//        List<Integer> player = Arrays.asList(99);
        System.out.println(climbingLeaderboard2(ranked, player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>(player.size());
        for (Integer score : player) {
            Set<Integer> scores = new HashSet<>(ranked);
            scores.add(score);
            int index = scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(score);
            result.add(index + 1);
        }
        return result;
    }

    public static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>(player.size());
        Set<Integer> deduplicateScores = new LinkedHashSet<>(ranked);
        ranked = new ArrayList<>(deduplicateScores);
        for (Integer score : player) {
            int low = 0;
            int high = ranked.size() -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (score.equals(ranked.get(mid))) {
                    result.add(mid + 1);
                    break;
                }else if (score > ranked.get(mid)) {
                    if (mid == 0 || score < ranked.get(mid -1)) {
                        result.add(mid + 1);
                        break;
                    }
                    high = mid - 1;
                }else {
                    if (mid == ranked.size() -1 || score > ranked.get(mid + 1)) {
                        result.add(mid + 2);
                        break;
                    }
                    low = mid + 1;
                }
            }
        }
        return result;
    }
}
