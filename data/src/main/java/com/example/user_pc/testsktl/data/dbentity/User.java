package com.example.user_pc.testsktl.data.dbentity;

/**
 * Created by USER-PC on 04.09.2017.
 */

public class User {

    //запросы к базе данных выполняются в UI потоке по умолчанию
//sqlLite не все поддерживает из MySql
    //"SELECT * FROM user  WHERE countryId=1" - выборка всех полей из юзера где countryId равно 1
    //"SELECT * FROM user WHERE name='Андрей'"- выборка всех полей из юзера где имя равно Андрей
    //"SELECT * FROM user INNER JOIN country ON user.countryId=country.id"- выборка всех полей из юзера и кантри по определенному полю
    //INNER JOIN вернет одну общую таблицу только если  их поля можносоединить по условию user.countryId=country.id
    //INNER JOIN если в одной таблице не будет такого поля то строка удалится (не вернется)
    //"SELECT * FROM user LEFT JOIN country ON user.countryId=country.id" - выборка из таблицы юзер все и еслив кантри ничего не найдется то справа будет null в одной общей таблице
    //"SELECT * FROM user RIGHT JOIN country ON user.countryId=country.id" - выборка из таблицы кантри все и еслив юзер  ничего не найдется то слева будет null в одной общей таблице
    //"SELECT * FROM user RIGHT JOIN country ON user.countryId=country.id WHERE <условие >"
    //"SELECT * FROM user  LIMIT 20" - вернет первых 20 значений
    //"SELECT * FROM user  LIMIT 20 OFFSET 20"  - вернет  c 20 позиции до позиции 40
    //"SELECT * FROM user  ORDER BY age"  - сортирует
    //"SELECT * FROM user  ORDER BY age ASC"  - сортирует c меньшего к большему
    //"SELECT * FROM user  ORDER BY age DESC"  - сортирует n большего к меньшему
    //еще есть INSERT и UPDATE


    private int id;
    private String name;
    private int age;
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
