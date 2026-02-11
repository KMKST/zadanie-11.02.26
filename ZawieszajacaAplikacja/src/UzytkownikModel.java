public class UzytkownikModel {

    public boolean walidujLogowanie(String user, String pass) {
        try {
            Thread.sleep(2500); // Symulacja zapytania do bazy danych
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user.equals("admin") && pass.equals("haslo123");
    }
}
