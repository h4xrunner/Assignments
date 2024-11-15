import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class dvd {

    public static void main(String[] args) throws InterruptedException, IOException {
        int width = 40;   // Terminal genişliği
        int height = 20;  // Terminal yüksekliği
        int x = 0, y = 0; // Başlangıç konumu
        int dx = 1, dy = 1; // Hareket yönü
        
        String dvdText = "DVD";

        while (true) {
            // Terminali temizle
            clearScreen();

            // Yazıyı yeni konumuna yerleştir
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == y && j == x) {
                        System.out.print(dvdText);
                        j += dvdText.length() - 1;  // DVD yazısının uzunluğu kadar atla
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            // Konumu güncelle
            x += dx;
            y += dy;

            // Kenarlardan sekme
            if (x <= 0 || x >= width - dvdText.length()) {
                dx = -dx; // X yönünü ters çevir
            }
            if (y <= 0 || y >= height - 1) {
                dy = -dy; // Y yönünü ters çevir
            }

            // Kısa bir süre bekle
            TimeUnit.MILLISECONDS.sleep(60);
        }
    }

    // Terminali temizleme fonksiyonu
    private static void clearScreen() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
