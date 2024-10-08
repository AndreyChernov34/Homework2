package homework4;

import homework4.ex1_carwash.cars.Bus;
import homework4.ex1_carwash.cars.Car;
import homework4.ex1_carwash.CarWash;
import homework4.ex1_carwash.cars.LightCar;
import homework4.ex2_fly.Airplane;
import homework4.ex2_fly.Duck;
import homework4.ex2_fly.FlyException;
import homework4.ex2_fly.Flyable;
import homework4.ex3_sound_around.Bird;
import homework4.ex3_sound_around.Builder;
import homework4.ex3_sound_around.Driver;
import homework4.ex3_sound_around.Human;
import homework4.ex3_sound_around.abstract_classes.MakingSound;

public class Runner {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    public static void ex1() {
            //Создать легковую машину (атрибуты: чистая/грязная, размеры(ширина,высота,длина), наличие круиз контроля)
            //Создать автобус (атрибуты: чистый/грязный, размеры(ширина,высота,длина), макс количество пассажиров)
            //Создать автомойку
            //Автомойка умеет мыть машину. Делает машину чистой. Возвращает стоимость помывки.
            //Автомойка умеет мыть машины. Делает машины чистыми. Возвращает стоимость помывки за все машины.
            //Категории автомобилей:
            //если длина > 6 или высота > 2.5 метра или ширина > 2, то машина считается крупной
            //иначе считается маломерной.
            //тариф 4000 - для крупных авто.
            //тариф 2000 - для маломерных.
            //В автомойку были отправлены грязные машины мэрии: 4 легковых(длина высота ширина) (5х2х1.8),
            //5 автобусов(12х3х2.3)
            //Посчитать и вывести: сколько мэрия заплатит денег за мойку всех машин.
        Car lightCar = new LightCar(false, 1800, 2000, 5000, true);
        Car bus = new Bus(false, 2300, 3000, 12000, 55);
        CarWash carWash = new CarWash();
        carWash.doWashCar(lightCar);
        carWash.doWashCar(bus);
        // создаем массив машин мэрии
        Car[] cars = new Car[9];
        for (int i = 0; i < cars.length; i++) {
            if (i < 4) {
                LightCar lightCarMajor = new LightCar(false,  1800, 2000, 5000,  true);
                cars[i] = lightCarMajor;
            }   else {
                Bus busMajor = new Bus(false,  3000, 2300, 12000, 45);
                cars[i] = busMajor;
            }
        }
        carWash.doWashCars(cars);
    }

    public static void ex2() {
            //Задача №2
            //1. Создать два класса, которые умеют летать: самолет и утка. Атрибут утки: isInjured (ранен),
            // атрибут самолета: countPassengers.
            //2. Создать интерфейс, который объединяет эти два класса.
            //3. Имплементировать его в двух классах
            //4. Реализовать метод летать:
            // Для утки:
            // Метод летать будет выкидывать ошибку FlyException (создать такой класс), если утка подстрелена,
            // иначе печатать на экран "утка летит"
            // Для самолета:
            // Метод летать будет выкидывать ошибку FlyException, если количество пассажиров меньше нуля.
            // Иначе печать "самолет летит"
            //5. Создать 1 утку не раненую, 1 утку раненую, 1 самолет с 10 пассажирами, 1 самолет с -1 пассажиром.
            //6. Вызвать у них метод летать
            // Перехватить исключения: вывести на экран текст
            // Ожидание (то что будет в консоли):
            // утка летит
            // Ошибка: утка ранена
            // самолет летит
            // Ошибка: пассажиров в самолете меньше 0
        Flyable[] flyable = new Flyable[4];
        flyable[0] = new Duck(false);
        flyable[1] = new Duck(true);
        flyable[2] =  new Airplane(10);
        flyable[3] =  new Airplane(-1);

        for (Flyable flyable1 : flyable) {
            try {
                flyable1.fly();
            } catch  (FlyException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static void ex3() {
            //Задача №3 - Звук вокруг
            //Человек умеет издавать звук: "Я человек." (возвращается строка и в след пунктах тоже)
            //Строитель умеет издавать звук: "Я строитель." + звук из человека
            //Водитель умеет издавать звук: "Я водитель." (водитель является человеком,
            // но не использует его родительский метод)
            //Птица умеет издавать звук: "Чирик"
            //Сделать так, чтобы они все могли быть представлены к единому типу - "Издающий звук".
            //Создать в этом методе человека, строителя, водителя и птицу. Запихнуть в единый массив.
            //Пройтись по массиву и заставить их издать звуки.
        MakingSound[] makingSounds = new MakingSound[4];
        makingSounds[0] = new Human();
        makingSounds[1] = new Builder();
        makingSounds[2] = new Driver();
        makingSounds[3] = new Bird();

        for (MakingSound makingSound : makingSounds) {
            makingSound.makeSound();
        }
    }

    public static void ex4() {
        //Задача №4 - Страсти по Дарвину
        //Создать следующую структуру
        //             Живое
        //       /             \
        //    Хищник             Травоядное
        //    /   \              /         \
        // волк   тигр       кролик        слон
        //
        //Живое - обладает свойством жив/мертв, вес. Умеет умирать - переход в состояние мертв.
        //
        //Хищник
        //Умеет нападать на живое. В случае если вес жертвы больше хищника, то хищник погибает,
        //иначе вес хищника увеличивается на треть веса жертвы и жертва погибает.
        //Может нападать только при живом состоянии, иначе выпадает ошибка "Животное не может нападать".
        //
        //Травоядное - умеет бегать (не определено как).
        // Но все травоядные могут бегать только в состоянии живое.
        //Иначе выдает ошибку - "Животное не может бегать".
        //
        //Тигр умеет нападать на живое, но за счет ловкости может сьесть жертву весом до двух раз больше него.
        //Остальные условия такие же как при нападении хищника.
        //
        //Волк - не обладает уникальными свойствами или действиями.
        //Кролик - умеет бегать (печать "кролик быстро бежит")
        //Слон - умеет бегать (печать "слон медленно бежит")
        //
        //Создать отдельный пакет и Runner. В Runner:
        //1.Создать Тигра(300 кг), Волка(50 кг), кролика(2 кг), Слона (2000 кг)
        //2.Кролик должен пробежать
        //3.Волк ест кролика
        //4.Тигр ест волка
        //5.Тигр пытается съесть слона
        //6.Слон пробегает
        //7.Вызвать у съеденного кролика бег, сделать так, чтобы программа НЕ закончилась с ошибкой,
        //а распечатала текст ошибки.
    }
}