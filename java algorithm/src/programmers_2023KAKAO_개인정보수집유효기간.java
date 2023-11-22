import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class programmers_2023KAKAO_개인정보수집유효기간 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};

            //trerm to map
            Map<String, Integer> termList = Arrays.stream(terms)
                    .map(term -> term.split(" "))
                    .collect(Collectors.toMap(term -> term[0], term -> Integer.valueOf(term[1])));
            System.out.println(termList);

            AtomicInteger index = new AtomicInteger(1);

            Date todayDate = new Date(today);
            return Arrays.stream(privacies)
                    .map(privacy -> privacy.split(" "))
                    .map(privacy -> new Date(privacy[0], termList.get(privacy[1]), index.getAndIncrement()))
                    .filter(date -> todayDate.compareDate(date) >= 0)
                    .mapToInt(date -> date.getId())
                    .toArray();



        }
    }

    class Date {
        private Map<String, Integer> start_time;
        private Map<String, Integer> end_time;
        private int term;
        private int id;

        public Date(String today) {
            this.start_time = parseStringToTimeMap(today);
        }

        public Date(String time, int term, int id) {
            this.start_time = parseStringToTimeMap(time);
            this.term = term;
            this.id = id;
            this.end_time = calculateEndTime(start_time, term);
        }

        private Map<String, Integer> calculateEndTime(Map<String, Integer> start_time, int term) {
            Map<String, Integer> result = new HashMap();

            int year = start_time.get("year");
            int month = start_time.get("month") + term;
            int day = start_time.get("day");

            while (month > 12) {
                month -= 12;
                year++;
            }
            result.put("year", year);
            result.put("month", month);
            result.put("day", day);

            return result;
        }

        private Map<String, Integer> parseStringToTimeMap(String time) {
            Map<String, Integer> result = new HashMap<>();

            String[] times = time.split("\\.");

            result.put("year", Integer.valueOf(times[0]));
            result.put("month", Integer.valueOf(times[1]));
            result.put("day", Integer.valueOf(times[2]));

            return result;
        }


        public int compareDate(Date date) {
            int yearGap = this.start_time.get("year") - date.end_time.get("year");
            int monthGap = this.start_time.get("month") - date.end_time.get("month");
            int dayGap = this.start_time.get("day") - date.end_time.get("day");

            if (yearGap != 0) {
                return yearGap;
            }
            if (monthGap != 0) {
                return monthGap;
            }

            return dayGap;
        }

        public int getId() {
            return id;
        }
    }
}
