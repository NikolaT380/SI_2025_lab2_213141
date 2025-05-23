# SI_2025_lab2_213141
Nikola Tanevski, 213141

2. CFG
   ![CFG1](assets/CFG1.svg)

   
3. Цикломатска комплексност
   Се пресметува со формулата M = број на decision points + 1
   Decision point е место каде треба да се донесе некоја одлука како if, for, while...
   for се брои како еден decision point, а секој услов од if е посебен decision point, пример if(a || b || c)
   има 3 decision points
   Даденеот код има цикломатска комплексност M = 12 + 1, односно M = 13.
   
4. За да се постигне Every Statement критериумот потребни се минимум 5 тест случаи:
   tc1 -> allItems == null -> RuntimeException("allItems list can't be null!");
   tc2 -> item.getName().length() == 0 -> RuntimeException("Invalid item!");
   tc3 -> нека item.getDiscount() > 0, па ќе се тестираат sum -= 30; и sum += item.getPrice() * (1 - item.getDiscount()) * item.getQuantity(); и нека cardNumber.length() != 16 па ќе има RuntimeException("Invalid card number!");
   tc4 -> нека cardNumber има невалидни знаци (1234abc789) па ќе има RuntimeException("Invalid character in card number!");
   tc5 -> нека item.getDiscount() == 0 за да се провери else делот sum += item.getPrice() * item.getQuantity() и нека cardNumber е валиден 16цифрен број за да може правилно да заврши програмата
   
5. Бидејќи имаме три проверки во условот if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10), потребни ќе ни бидат 2^3 односно 8 тест случаи за да биде исполнет Multiple Condition критериумот:
   tc1 -> (F || F || F) -> item.getPrice() <= 300 || item.getDiscount() <= 0 || item.getQuantity() <= 10 -> Item("item1", 1, 100, 0)
   tc2 -> (F || F || T) -> item.getPrice() <= 300 || item.getDiscount() <= 0 || item.getQuantity() > 10 -> Item("item2", 11, 100, 0)
   tc3 -> (F || T || F) -> item.getPrice() <= 300 || item.getDiscount() > 0 || item.getQuantity() <= 10 -> Item("item3", 1, 100, 0.2)
   tc4 -> (F || T || T) -> item.getPrice() <= 300 || item.getDiscount() > 0 || item.getQuantity() > 10 -> Item("item4", 11, 100, 0.1)
   tc5 -> (T || F || F) -> item.getPrice() > 300 || item.getDiscount() <= 0 || item.getQuantity() <= 10 -> Item("item5", 1, 400, 0)
   tc6 -> (T || F || T) -> item.getPrice() > 300 || item.getDiscount() <= 0 || item.getQuantity() > 10 -> Item("item6", 11, 400, 0)
   tc7 -> (T || T || F) -> item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() <= 10 -> Item("item7", 1, 400, 0.25)
   tc8 -> (T || T || T) -> item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10 -> Item("item8", 11, 400, 0.1)
   Само во првиот тест случај условот нема да биде исполнет и сумата нема да се намали за 30.
   
