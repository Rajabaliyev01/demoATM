// Rajabaliyev01
import java.util.Scanner;


public class MiniATM {
    public static int hisobdagiPul = 1_000_000;
    public static int parol = 1234;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        languages();
    }
    public static int readInt() {
        String s = input.next();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void languages() {
        System.out.println("""
        Kirish / Вход / Login
        1. O'zbekcha
        2. Русский
        3. English
        """);
        int language = readInt();
        switch (language) {
            case 1 -> askPasswordUz();
            case 2 -> askPasswordRu();
            case 3 -> askPasswordEng();
            default -> {
                System.out.println("Tilni tanlang \nВыберите язык \nSelect language");
                languages();
            }
        }
    }

    public static void askPasswordUz() {
        System.out.print("Plastik kartangizning parolini kiriting: ");
        int key = readInt();
        if (key == parol) {
            System.out.println("Tizimga kirdingiz");
            boshMenyuUz();
        } else {
            System.out.println("Parol noto'g'ri. Iltimos qaytadan urinib ko'ring");
            askPasswordUz();
        }
    }

    public static void boshMenyuUz() {
        System.out.println("""
                Bosh menyu
                1. Balansni tekshirish 
                2. Naqd pul olish
                3. SMS xabar ulash/ o'chirish
                4. Parolni o'zgartirish
                5. Mobil aloqa uchun to'lov
                6. Kredit to'lovlari
                7. Kommunal to'lovlar
                8. Dasturdan chiqish
                """);
        int key = readInt();
        switch (key) {
            case 1 -> balansniTekshirishUz();
            case 2 -> naqdOlishUz();
            case 3 -> smsSettingUz();
            case 4 -> changePasswordUz();
            case 5 -> mobilePaymentUz();
            case 6 -> creditPaymentUz();
            case 7 -> utilityPaymentUz();
            case 8 -> {
                System.out.println("Dasturdan chiqdingiz");
                System.exit(0);
            }
            default -> {
                System.out.println("Noto'g'ri tanlov. Iltimos qaytadan urinib ko'ring");
                boshMenyuUz();
            }
        }
    }

    public static void balansniTekshirishUz() {
        System.out.println("Balansingizdagi miqdor (so'm): " + hisobdagiPul);
        boshMenyuUz();
    }

    public static void naqdOlishUz() {
        System.out.println("""
                Naqd pul olish
                1. 50 000
                2. 100 000
                3. 150 000
                4. 200 000
                5. 300 000
                6. 400 000
                7. Boshqa summa
                8. Ortga
                """);
        int naqd = readInt();
        switch (naqd) {
            case 1 -> naqd = 50000;
            case 2 -> naqd = 100000;
            case 3 -> naqd = 150000;
            case 4 -> naqd = 200000;
            case 5 -> naqd = 300000;
            case 6 -> naqd = 400000;
            case 7 -> {
                System.out.println("Summa kiriting: ");
                naqd = readInt();
            }
            case 8 -> {
                boshMenyuUz();
                return;
            }
            default -> {
                System.out.println("Noto'g'ri tanlov.");
                naqdOlishUz();
                return;
            }
        }
        if (naqd <= 0) {
            System.out.println("Summa noto'g'ri");
        } else if (naqd > hisobdagiPul) {
            System.out.println("Mablag' yetarli emas");
        } else {
            hisobdagiPul -= naqd;
            System.out.println(naqd + " so'm yechib olindi. Yangi balans (so'm): " + hisobdagiPul);
        }
        boshMenyuUz();
    }

    public static void smsSettingUz() {
        System.out.print("Telefon raqamingizni kiriting:");
        String phoneNumber = input.next();

        System.out.println("""
        SMS xabar ulash/o'chirish
        1. SMS xabar ulash
        2. SMS xabar o'chirish
        3. Orqaga
        """);

        int key = readInt();
        switch (key) {
            case 1 -> System.out.println("SMS xabar " + phoneNumber + " telefon nomerga yoqildi");
            case 2 -> System.out.println("SMS xabar " + phoneNumber + " telefon nomerdan o'chirildi");
            case 3 -> {
                boshMenyuUz();
                return;
            }
            default -> System.out.println("Noto'g'ri tanlov.");
        }
        boshMenyuUz();
    }

    public static void changePasswordUz() {
        System.out.print("Eski parolni kiriting:");
        int oldPassword = readInt();
        if (oldPassword == parol) {
            System.out.print("Yangi parol kiriting:");
            int newPassword = readInt();
            System.out.print("Yangi parolni qayta kiriting:");
            int newPassword2 = readInt();
            if (newPassword == newPassword2) {
                parol = newPassword;
                System.out.println("Parol muvaffaqiyatli o'zgartirildi");
            } else {
                System.out.println("Parollar mos kelmadi. Iltimos qaytadan urinib ko'ring");
                changePasswordUz();
                return;
            }

        } else {
            System.out.println("Parol noto'g'ri. Iltimos qaytadan urinib ko'ring");
            changePasswordUz();
            return;
        }
        boshMenyuUz();
    }

    public static void mobilePaymentUz() {
        System.out.println("""
        Mobil aloqa uchun to'lov
        1. UzMobile
        2. Beeline
        3. Mobiuz
        4. Ucell
        5. Orqaga
        """);

        int key = readInt();

        if (key < 1 || key > 5) {
            System.out.println("Noto'g'ri tanlov.");
            mobilePaymentUz();
            return;
        }

        if (key == 5) {
            boshMenyuUz();
            return;
        } else {
            System.out.print("Telefon raqamingizni kiriting:");
            String phoneNumber = input.next();
            System.out.print("To'lov miqdorini kiriting: ");
            int amount = readInt();

            if (amount <= 0) {
                System.out.println("Summa noto'g'ri");
            } else if (amount > hisobdagiPul) {
                System.out.println("Balansda yetarli mablag' mavjud emas");
            } else {
                hisobdagiPul -= amount;
                System.out.println(amount + " so'm " + phoneNumber + " raqamiga to'lov qilindi. Sizning balansingizda "
                                   + hisobdagiPul + " so'm qoldi");
            }
            boshMenyuUz();

        }
    }

    public static void creditPaymentUz() {
        System.out.println("Kredit raqamini kiriting: ");
        String creditNumber = input.next();
        System.out.println("To'lov miqdorini kiriting: ");
        int amount = readInt();
        if (amount <= 0) {
            System.out.println("Summa noto'g'ri");
        } else if (amount > hisobdagiPul) {
            System.out.println("Balansda yetarli mablag' mavjud emas");
        } else {
            hisobdagiPul -= amount;
            System.out.println(amount + " so'm " + creditNumber + " raqamiga to'lov qilindi. Sizning balansingizda "
                               + hisobdagiPul + " so'm qoldi");
        }
        boshMenyuUz();
    }

    public static void utilityPaymentUz() {
        System.out.println("""
        Kommunal to'lovlar
        1. Elektr energiyasi
        2. Jarimalar
        3. Gaz
        4. Suv
        5. Orqaga
        """);

        int key = readInt();
        if (key < 1 || key > 5) {
            System.out.println("Noto'g'ri tanlov.");
            utilityPaymentUz();
            return;
        }
        if (key == 5) {
            boshMenyuUz();
            return;
        } else {
            System.out.print("To'lov miqdorini kiriting:");
            int amount = readInt();
            if (amount <= 0) {
                System.out.println("Summa noto'g'ri");
            } else if (amount > hisobdagiPul) {
                System.out.println("Balansda yetarli mablag' mavjud emas");
            } else {
                hisobdagiPul -= amount;
                System.out.println("Kommunal to'lov amalga oshirildi");
            }
            boshMenyuUz();
        }
    }


    public static void askPasswordRu() {
        System.out.print("Введите пароль от вашей пластиковой карты: ");
        int key = readInt();
        if (key == parol) {
            System.out.println("Вы вошли в систему");
            boshMenyuRu();
        } else {
            System.out.println("Неверный пароль. Пожалуйста, попробуйте еще раз");
            askPasswordRu();
        }
    }

    public static void boshMenyuRu() {
        System.out.println("""
                Главное меню
                1. Проверить баланс
                2. Снять наличные
                3. Включить/отключить SMS-сообщения
                4. Изменить пароль
                5. Оплата мобильной связи
                6. Оплата кредитов
                7. Оплата коммунальных услуг
                8. Выйти из приложения
                """);
        int key = readInt();
        switch (key) {
            case 1 -> balansniTekshirishRu();
            case 2 -> naqdOlishRu();
            case 3 -> smsSettingRu();
            case 4 -> changePasswordRu();
            case 5 -> mobilePaymentRu();
            case 6 -> creditPaymentRu();
            case 7 -> utilityPaymentRu();
            case 8 -> {
                System.out.println("Вы вышли из программы.");
                System.exit(0);
            }
            default -> {
                System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                boshMenyuRu();
            }
        }
    }

    public static void balansniTekshirishRu() {
        System.out.println("Сумма на балансе (сум): " + hisobdagiPul);
        boshMenyuRu();
    }

    public static void naqdOlishRu() {
        System.out.println("""
                Снять наличные
                1. 50 000
                2. 100 000
                3. 150 000
                4. 200 000
                5. 300 000
                6. 400 000
                7. Другая сумма
                8. Назад
                """);
        int naqd = readInt();
        switch (naqd) {
            case 1 -> naqd = 50000;
            case 2 -> naqd = 100000;
            case 3 -> naqd = 150000;
            case 4 -> naqd = 200000;
            case 5 -> naqd = 300000;
            case 6 -> naqd = 400000;
            case 7 -> {
                System.out.println("Введите сумму: ");
                naqd = readInt();
            }
            case 8 -> {
                boshMenyuRu();
                return;
            }
            default -> {
                System.out.println("Неверный выбор.");
                naqdOlishRu();
                return;
            }
        }
        if (naqd <= 0) {
            System.out.println("Неверная сумма");
        } else if (naqd > hisobdagiPul) {
            System.out.println("Недостаточно средств");
        } else {
            hisobdagiPul -= naqd;
            System.out.println(naqd + " сум снято. Новый баланс: " + hisobdagiPul + " сум");
        }
        boshMenyuRu();
    }

    public static void smsSettingRu() {
        System.out.print("Введите ваш номер телефона: ");
        String phoneNumber = input.next();

        System.out.println("""
                Подключение/отключение SMS-уведомлений
                1. Подключить SMS
                2. Отключить SMS
                3. Назад
                """);
        int key = readInt();
        switch (key) {
            case 1 -> System.out.println("SMS-уведомления подключены к номеру " + phoneNumber);
            case 2 -> System.out.println("SMS-уведомления отключены от номера " + phoneNumber);
            case 3 -> {
                boshMenyuRu();
                return;
            }
            default -> System.out.println("Неверный выбор.");
        }
        boshMenyuRu();
    }

    public static void changePasswordRu() {
        System.out.print("Введите старый пароль: ");
        int oldPassword = readInt();
        if (oldPassword == parol) {
            System.out.print("Введите новый пароль: ");
            int newPassword = readInt();
            System.out.print("Повторите новый пароль: ");
            int newPassword2 = readInt();
            if (newPassword == newPassword2) {
                parol = newPassword;
                System.out.println("Пароль успешно изменен");
            } else {
                System.out.println("Пароли не совпадают. Пожалуйста, попробуйте еще раз");
                changePasswordRu();
                return;
            }
        } else {
            System.out.println("Неверный пароль. Пожалуйста, попробуйте еще раз");
            changePasswordRu();
            return;
        }
        boshMenyuRu();
    }

    public static void mobilePaymentRu() {
        System.out.println("""
                Оплата мобильной связи
                1. UzMobile
                2. Beeline
                3. Mobiuz
                4. Ucell
                5. Назад
                """);

        int key = readInt();
        if (key < 1 || key > 5) {
            System.out.println("Неверный выбор.");
            mobilePaymentRu();
            return;
        }

        if (key == 5) {
            boshMenyuRu();
            return;
        } else {
            System.out.print("Введите номер телефона: ");
            String phoneNumber = input.next();
            System.out.print("Введите сумму платежа: ");
            int amount = readInt();

            if (amount <= 0) {
                System.out.println("Неверная сумма");
            } else if (amount > hisobdagiPul) {
                System.out.println("На балансе недостаточно средств");
            } else {
                hisobdagiPul -= amount;
                System.out.println(amount + " сум оплачено на номер " + phoneNumber
                                   + ". На вашем балансе осталось " + hisobdagiPul + " сум");
            }
            boshMenyuRu();
        }
    }

    public static void creditPaymentRu() {
        System.out.println("Введите номер кредита: ");
        String creditNumber = input.next();
        System.out.println("Введите сумму платежа: ");
        int amount = readInt();
        if (amount <= 0) {
            System.out.println("Неверная сумма");
        } else if (amount > hisobdagiPul) {
            System.out.println("На балансе недостаточно средств");
        } else {
            hisobdagiPul -= amount;
            System.out.println(amount + " сум оплачено по кредиту " + creditNumber
                               + ". На вашем балансе осталось " + hisobdagiPul + " сум");
        }
        boshMenyuRu();
    }

    public static void utilityPaymentRu() {
        System.out.println("""
                Коммунальные платежи
                1. Электроэнергия
                2. Штрафы
                3. Газ
                4. Вода
                5. Назад
                """);

        int key = readInt();
        if (key < 1 || key > 5) {
            System.out.println("Неверный выбор.");
            utilityPaymentRu();
            return;
        }

        if (key == 5) {
            boshMenyuRu();
            return;
        } else {
            System.out.print("Введите сумму платежа: ");
            int amount = readInt();
            if (amount <= 0) {
                System.out.println("Неверная сумма");
            } else if (amount > hisobdagiPul) {
                System.out.println("На балансе недостаточно средств");
            } else {
                hisobdagiPul -= amount;
                System.out.println("Коммунальный платеж успешно выполнен");
            }
            boshMenyuRu();
        }
    }


    public static void askPasswordEng() {
        System.out.print("Enter your plastic card PIN: ");
        int key = readInt();
        if (key == parol) {
            System.out.println("You have logged into the system");
            boshMenyuEng();
        } else {
            System.out.println("Incorrect PIN. Please try again");
            askPasswordEng();
        }
    }

    public static void boshMenyuEng() {
        System.out.println("""
                Main Menu
                1. Check balance
                2. Withdraw cash
                3. Enable/disable SMS notifications
                4. Change password
                5. Mobile service payment
                6. Loan payments
                7. Utility payments
                8. Exit application
                """);
        int key = readInt();
        switch (key) {
            case 1 -> balansniTekshirishEng();
            case 2 -> naqdOlishEng();
            case 3 -> smsSettingEng();
            case 4 -> changePasswordEng();
            case 5 -> mobilePaymentEng();
            case 6 -> creditPaymentEng();
            case 7 -> utilityPaymentEng();
            case 8 -> {
                System.out.println("You have exited the program");
                System.exit(0);
            }
            default -> {
                System.out.println("Incorrect choice. Please try again.");
                boshMenyuEng();
            }
        }
    }

    public static void balansniTekshirishEng() {
        System.out.println("Balance amount (UZS): " + hisobdagiPul);
        boshMenyuEng();
    }

    public static void naqdOlishEng() {
        System.out.println("""
                Withdraw cash
                1. 50 000
                2. 100 000
                3. 150 000
                4. 200 000
                5. 300 000
                6. 400 000
                7. Other amount
                8. Back
                """);
        int naqd = readInt();
        switch (naqd) {
            case 1 -> naqd = 50000;
            case 2 -> naqd = 100000;
            case 3 -> naqd = 150000;
            case 4 -> naqd = 200000;
            case 5 -> naqd = 300000;
            case 6 -> naqd = 400000;
            case 7 -> {
                System.out.println("Enter amount: ");
                naqd = readInt();
            }
            case 8 -> {
                boshMenyuEng();
                return;
            }
            default -> {
                System.out.println("Incorrect choice");
                naqdOlishEng();
                return;
            }
        }
        if (naqd <= 0) {
            System.out.println("Invalid amount");
        } else if (naqd > hisobdagiPul) {
            System.out.println("Insufficient funds");
        } else {
            hisobdagiPul -= naqd;
            System.out.println(naqd + " UZS withdrawn. New balance (UZS): " + hisobdagiPul);
        }
        boshMenyuEng();
    }

    public static void smsSettingEng() {
        System.out.print("Enter your phone number: ");
        String phoneNumber = input.next();

        System.out.println("""
                SMS notifications settings
                1. Enable SMS notifications
                2. Disable SMS notifications
                3. Back
                """);

        int key = readInt();
        switch (key) {
            case 1 -> System.out.println("SMS notifications enabled for " + phoneNumber);
            case 2 -> System.out.println("SMS notifications disabled for " + phoneNumber);
            case 3 -> {
                boshMenyuEng();
                return;
            }
            default -> System.out.println("Incorrect choice");
        }
        boshMenyuEng();
    }

    public static void changePasswordEng() {
        System.out.print("Enter old PIN: ");
        int oldPassword = readInt();
        if (oldPassword == parol) {
            System.out.print("Enter new PIN: ");
            int newPassword = readInt();
            System.out.print("Re-enter new PIN: ");
            int newPassword2 = readInt();
            if (newPassword == newPassword2) {
                parol = newPassword;
                System.out.println("PIN has been successfully changed");
            } else {
                System.out.println("PINs don't match. Please try again");
                changePasswordEng();
                return;
            }
        } else {
            System.out.println("Incorrect PIN. Please try again");
            changePasswordEng();
            return;
        }
        boshMenyuEng();
    }

    public static void mobilePaymentEng() {
        System.out.println("""
                Mobile service payment
                1. UzMobile
                2. Beeline
                3. Mobiuz
                4. Ucell
                5. Back
                """);

        int key = readInt();
        if (key < 1 || key > 5) {
            System.out.println("Incorrect choice");
            mobilePaymentEng();
            return;
        }

        if (key == 5) {
            boshMenyuEng();
        } else {
            System.out.print("Enter phone number: ");
            String phoneNumber = input.next();
            System.out.print("Enter payment amount: ");
            int amount = readInt();

            if (amount <= 0) {
                System.out.println("Invalid amount");
            } else if (amount > hisobdagiPul) {
                System.out.println("Insufficient funds on balance");
            } else {
                hisobdagiPul -= amount;
                System.out.println(amount + " UZS paid to " + phoneNumber + ". Remaining balance: " + hisobdagiPul + " UZS");
            }
            boshMenyuEng();
        }
    }

    public static void creditPaymentEng() {
        System.out.println("Enter loan account number: ");
        String creditNumber = input.next();
        System.out.println("Enter payment amount: ");
        int amount = readInt();
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > hisobdagiPul) {
            System.out.println("Insufficient funds on balance");
        } else {
            hisobdagiPul -= amount;
            System.out.println(amount + " UZS paid for loan " + creditNumber + ". Remaining balance: " + hisobdagiPul + " UZS");
        }
        boshMenyuEng();
    }

    public static void utilityPaymentEng() {
        System.out.println("""
                Utility payments
                1. Electricity
                2. Fines
                3. Gas
                4. Water
                5. Back
                """);

        int key = readInt();
        if (key < 1 || key > 5) {
            System.out.println("Incorrect choice");
            utilityPaymentEng();
            return;
        }

        if (key == 5) {
            boshMenyuEng();
            return;
        } else {
            System.out.print("Enter payment amount: ");
            int amount = readInt();
            if (amount <= 0) {
                System.out.println("Invalid amount");
            } else if (amount > hisobdagiPul) {
                System.out.println("Insufficient funds on balance");
            } else {
                hisobdagiPul -= amount;
                System.out.println("Utility payment successfully completed");
            }
            boshMenyuEng();
        }
    }
}
