        package Sliding_Window;

        import java.util.Arrays;
        import java.util.HashSet;

        //import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

        public class O03_Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length {
            public static void main(String[] args) {
                String s = "abciiidef";
                int k = 3;

                System.out.println(maxVowels(s, k));
            }

            public static int maxVowels(String s, int k) {
                HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

                int currCount = 0;
                for(int i=0; i<k; i++){
                    if(set.contains(s.charAt(i))){
                        currCount++;
                    }
                }
                int maxCount  = currCount;
                for(int i=k; i<s.length(); i++){
                    if(set.contains(s.charAt(i-k))){
                        currCount--;
                    }

                    if(set.contains(s.charAt(i))){
                        currCount++;
                    }

                    maxCount = Math.max(maxCount, currCount);
                }

                return maxCount;
            }
        }
