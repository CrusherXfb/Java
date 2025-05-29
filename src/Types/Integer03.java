package Types;

public class Integer03 {
    public static void main (String[] args) {
        long fSizeB = 1192929555353333336L;
        long fSizeKB = fSizeB >> 10;
        long fSizeMB = fSizeKB >> 10;
        long fSizeGB = fSizeMB >> 10;
        long fSizeTB = fSizeGB >> 10;
        long fSizePB = fSizeTB >> 10;
        long fSizeEB = fSizePB >> 10;
        System.out.print(
                "Байты: " + fSizeB + "\n" +
                "Килобайты: " + fSizeKB + "\n" +
                "Мегабайты: " + fSizeMB + "\n" +
                "Гигабайты: " + fSizeGB + "\n" +
                "Терабайты: " + fSizeTB + "\n" +
                "Петабайты: " + fSizePB + "\n" +
                "Экзобайты: " + fSizeEB + "\n"
        );
    }
}
