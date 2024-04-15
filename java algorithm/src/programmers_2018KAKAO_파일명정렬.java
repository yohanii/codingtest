import java.util.*;

public class programmers_2018KAKAO_파일명정렬 {

    class Solution {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];

            //1. Head, Number, Tail 구분
            //2. PriorityQueue, Comparable 사용해서 정렬
            PriorityQueue<File> queue = new PriorityQueue<>();
            for (int i = 0; i < files.length; i++) {
                File file = new File(i, files[i]);
                file.stringToFile();
                queue.add(file);
            }
            System.out.println(queue);

            for (int i = 0; i < files.length; i++) {
                answer[i] = files[queue.poll().getIndex()];
            }

            return answer;
        }

        class File implements Comparable<File> {
            private String head;
            private int number;
            private String tail;
            private int index;
            private String input;

            public File(int index, String input) {
                this.index = index;
                this.input = input;
            }

            public File(String head, int number, String tail) {
                this.head = head;
                this.number = number;
                this.tail = tail;
            }

            public void stringToFile() {
                int numStart = -1;
                int numEnd = -1;

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (numStart == -1 && c >= '0' && c <= '9') {
                        numStart = i;
                    }
                    if (numStart != -1 && (c < '0' || c > '9')) {
                        numEnd = i;
                        break;
                    }
                }

                this.head = input.substring(0, numStart);
                if (numEnd == -1) {
                    this.number = Integer.parseInt(input.substring(numStart));
                    return;
                }

                this.number = Integer.parseInt(input.substring(numStart, numEnd));
                this.tail = input.substring(numEnd);

            }

            public int getIndex() {
                return this.index;
            }


            @Override
            public int compareTo(File f) {

                String h1 = this.head.toLowerCase();
                String h2 = f.head.toLowerCase();

                if (h1.equals(h2)) {
                    if (this.number == f.number) {
                        return this.index - f.index;
                    }

                    return this.number - f.number;
                }

                return h1.compareTo(h2);
            }
        }
    }
}
