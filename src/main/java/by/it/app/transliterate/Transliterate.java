package by.it.app.transliterate;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.function.Function;

/**
 * The type Transliterate.
 */
public class Transliterate {

    /**
     * Transliterate string.
     *
     * @param cyrillicText the cyrillic text
     * @return the string of latin text
     */
    public static String transliterate(String cyrillicText) {
        Map<String, String> alphabet = ImmutableMap.<String, String>builder()
                .put("Бе", "Bie").put("Бё", "Bio").put("Бю", "Biu").put("Бя", "Bia")
                .put("Ве", "Vie").put("Вё", "Vio").put("Вю", "Viu").put("Вя", "Via")
                .put("Ге", "Hie").put("Гё", "Hio").put("Гю", "Hiu").put("Гя", "Hia")
                .put("Ґе", "Gie").put("Ґё", "Gio").put("Ґю", "Giu").put("Ґя", "Gia")
                .put("Зе", "Zie").put("Зё", "Zio").put("Зю", "Ziu").put("Зя", "Zia")
                .put("Ке", "Kie").put("Кё", "Kio").put("Кю", "Kiu").put("Кя", "Kia")
                .put("Ле", "Le").put("Лё", "Lo").put("Лю", "Lu").put("Ля", "La")
                .put("Ме", "Mie").put("Мё", "Mio").put("Мю", "Miu").put("Мя", "Mia")
                .put("Не", "Nie").put("Нё", "Nio").put("Ню", "Niu").put("Ня", "Nia")
                .put("Пе", "Pie").put("Пё", "Pio").put("Пю", "Piu").put("Пя", "Pia")
                .put("Се", "Sie").put("Сё", "Sio").put("Сю", "Siu").put("Ся", "Sia")
                .put("Фе", "Fie").put("Фё", "Fio").put("Фю", "Fiu").put("Фя", "Fia")
                .put("Це", "Cie").put("Цё", "Cio").put("Цю", "Ciu").put("Ця", "Cia")
                .put("А", "A").put("Б", "B").put("В", "V").put("Г", "H").put("Ґ", "G").put("Д", "D").put("Е", "Je").put("Ё", "Jo")
                .put("Ж", "Ž").put("З", "Z").put("І", "I").put("Й", "J").put("К", "K").put("Л", "Ł").put("М", "M").put("Н", "N")
                .put("О", "O").put("П", "P").put("Р", "R").put("С", "S").put("Т", "T").put("У", "U").put("Ў", "Ŭ").put("Ф", "F")
                .put("Х", "Ch").put("Ц", "C").put("Ч", "Č").put("Ш", "Š").put("Ы", "Y").put("Э", "E").put("Ю", "Ju").put("Я", "Ja")
                .put("зь", "ź").put("ль", "l").put("нь", "ń").put("сь", "ś").put("ць", "ć")
                .put("бе", "bie").put("бё", "bio").put("бю", "biu").put("бя", "bia")
                .put("ве", "vie").put("вё", "vio").put("вю", "viu").put("вя", "via")
                .put("ге", "hie").put("гё", "hio").put("гю", "hiu").put("гя", "hia")
                .put("ґе", "gie").put("ґё", "gio").put("ґю", "giu").put("ґя", "gia")
                .put("зе", "zie").put("зё", "zio").put("зю", "ziu").put("зя", "zia")
                .put("ке", "kie").put("кё", "kio").put("кю", "kiu").put("кя", "kia")
                .put("ле", "le").put("лё", "lo").put("лю", "lu").put("ля", "la")
                .put("ме", "mie").put("мё", "mio").put("мю", "miu").put("мя", "mia")
                .put("не", "nie").put("нё", "nio").put("ню", "niu").put("ня", "nia")
                .put("пе", "pie").put("пё", "pio").put("пю", "piu").put("пя", "pia")
                .put("се", "sie").put("сё", "sio").put("сю", "siu").put("ся", "sia")
                .put("фе", "fie").put("фё", "fio").put("фю", "fiu").put("фя", "fia")
                .put("це", "cie").put("цё", "cio").put("цю", "ciu").put("ця", "cia")
                .put("а", "a").put("б", "b").put("в", "v").put("г", "h").put("ґ", "g").put("д", "d").put("е", "je").put("ё", "jo")
                .put("ж", "ž").put("з", "z").put("і", "i").put("й", "j").put("к", "k").put("л", "ł").put("м", "m").put("н", "n")
                .put("о", "o").put("п", "p").put("р", "r").put("с", "s").put("т", "t").put("у", "u").put("ў", "ŭ").put("ф", "f")
                .put("х", "ch").put("ц", "c").put("ч", "č").put("ш", "š").put("ы", "y").put("э", "e").put("ю", "ju").put("я", "ja")
                .put("И", "I").put("Щ", "Šč").put("Ъ", "'").put("Ь", "")
                .put("и", "i").put("щ", "šč").put("ъ", "'").put("ь", "")
                .put("'", "")
                .build();

        return alphabet
                .entrySet()
                .stream()
                .map(text -> (Function<String, String>) s -> s.replace(text.getKey(), text.getValue()))
                .reduce(Function.identity(), Function::andThen).apply(cyrillicText);
    }
}
