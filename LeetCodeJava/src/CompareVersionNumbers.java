//#165 Compare Version Numbers
public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.println(cvn.compareVersion("1.01", "1.001"));
        System.out.println(cvn.compareVersion("1.0", "1.0.0"));
        System.out.println(cvn.compareVersion("0.1", "1.1"));
        System.out.println(cvn.compareVersion("1.0.1", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < revisions1.length || ptr2 < revisions2.length) {
            int num1 = 0;
            int num2 = 0;
            if (ptr1 < revisions1.length) {
                String r1 = revisions1[ptr1];
                num1 = Integer.parseInt(r1);
            }
            if (ptr2 < revisions2.length) {
                String r2 = revisions2[ptr2];
                num2 = Integer.parseInt(r2);
            }
            switch(Integer.compare(num1, num2)) {
                case 1:
                    return 1;
                case -1:
                    return -1;
            }
            ptr1++;
            ptr2++;

        }
        return 0;
    }
}
