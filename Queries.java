public class Queries {
   // Görevler
   // Aşağıda istenilen sonuçlara ulaşabilmek için gerekli SQL sorgularını yazın.
   // MIN-MAX, COUNT-AVG-SUM, GROUP BY, JOINS (INNER, OUTER, LEFT, RIGHT #ilk 3 soruyu join kullanmadan yazın.

   // 1) Öğrencinin adını, soyadını ve kitap aldığı tarihleri listeleyin.
    /*
    SELECT ograd, ogrsoyad, atarih
    FROM ogrenci o, islem i
    WHERE o.ogrno=i.ogrno;
     */

    // 2) Fıkra ve hikaye türündeki kitapların adını ve türünü listeleyin.
    /*
    SELECT kitapadi, turadi
    FROM kitap k, tur t
    WHERE t.turadi IN ('Fıkra', 'Hikaye');
     */

    // 3) 10B veya 10C sınıfındaki öğrencilerin numarasını, adını, soyadını ve okuduğu kitapları listeleyin.
    /*
    SELECT ogrno, ograd, ogrsoyad, kitapadi
    FROM ogrenci o, kitap k
    WHERE o.sinif IN ('10B', '10C');
     */

    // 4) Öğrencinin adını, soyadını ve kitap aldığı tarihleri listeleyin.
    /*
    SELECT ograd, ogrsoyad, atarih
    FROM ogrenci o
    INNER JOIN islem i
    ON o.ogrno=i.ogrno;
     */

    // 5) Fıkra ve hikaye türündeki kitapların adını ve türünü listeleyin.
    /*
    SELECT kitapadi, turadi
    FROM kitap k
    INNER JOIN tur t
    ON k.turno=t.turno
    WHERE t.turadi IN ('Fıkra','Hikaye');
     */

    // 6) 10B veya 10C sınıfındaki öğrencilerin numarasını, adını, soyadını ve okuduğu kitapları, öğrenci adına göre listeleyin.
    /*
    SELECT o.ogrno, ograd, ogrsoyad, kitapadi
    FROM ogrenci o
    INNER JOIN islem i
    ON o.ogrno=i.ogrno
    INNER JOIN kitap k
    ON i.kitapno=k.kitapno
    WHERE sinif IN ('10B','10C')
    ORDER BY ograd;
     */

    // 7) Kitap alan öğrencinin adı, soyadı, kitap aldığı tarih listelensin. Kitap almayan öğrencilerinde listede görünsün.
    /*
    SELECT ograd, ogrsoyad, atarih
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno;
     */

    // 8) Kitap almayan öğrencileri listeleyin.
    /*
    SELECT ograd, ogrsoyad
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno
    WHERE i.atarih IS NULL;
     */

    // 9) Alınan kitapların kitap numarasını, adını ve kaç defa alındığını kitap numaralarına göre artan sırada listeleyiniz.
    /*
    SELECT k.kitapno, k.kitapadi, COUNT(atarih)
    FROM kitap k
    INNER JOIN islem i
    ON k.kitapno=i.kitapno
    GROUP BY k.kitapno
    ORDER BY k.kitapno;
     */

    // 10) Alınan kitapların kitap numarasını, adını kaç defa alındığını (alınmayan kitapların yanında 0 olsun) listeleyin.
    /*
    SELECT k.kitapno, kitapadi, COUNT(atarih)
    FROM kitap k
    LEFT JOIN islem i
    ON k.kitapno=i.kitapno
    GROUP BY k.kitapno
     */

    // 11) Öğrencilerin adı soyadı ve aldıkları kitabın adı listelensin.
    /*
    SELECT ograd, ogrsoyad, kitapadi
    FROM ogrenci o
    INNER JOIN islem i
    ON o.ogrno=i.ogrno
    INNER JOIN kitap k
    ON i.kitapno=k.kitapno
     */

    // 12) Her öğrencinin adı, soyadı, kitabın adı, yazarın adı soyad ve kitabın türünü ve kitabın alındığı tarihi listeleyiniz. Kitap almayan öğrenciler de listede görünsün.
    /*
    SELECT ograd, ogrsoyad, kitapadi, yazarad, yazarsoyad, turadi, atarih
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno
    LEFT JOIN kitap k
    ON i.kitapno=k.kitapno
    LEFT JOIN yazar y
    ON k.yazarno=y.yazarno
    LEFT JOIN tur t
    ON k.turno=t.turno;
    */

    // 13) 10A veya 10B sınıfındaki öğrencilerin adı soyadı ve okuduğu kitap sayısını getirin.
    /*
    SELECT CONCAT(ograd,' ',ogrsoyad) AS adSoyad, COUNT(islemno)
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno
    WHERE sinif IN ('10A','10B')
    GROUP BY adSoyad;
     */

    // 14) Tüm kitapların ortalama sayfa sayısını bulunuz. //#AVG
    /*
    SELECT AVG(sayfasayisi) FROM kitap;
     */

    // 15) Sayfa sayısı ortalama sayfanın üzerindeki kitapları listeleyin.
    /*1
    SELECT * FROM kitap
    WHERE sayfasayisi > (SELECT AVG(sayfasayisi) FROM kitap);
     */

     /*2
    SELECT * FROM kitap
    HAVING sayfasayisi > (SELECT AVG(sayfasayisi) FROM kitap);
     */

    // 16) Öğrenci tablosundaki öğrenci sayısını gösterin
    // SELECT COUNT(*) FROM ogrenci;

    // 17) Öğrenci tablosundaki toplam öğrenci sayısını toplam sayı takma(alias kullanımı) adı ile listeleyin.
    /*
    SELECT COUNT(*) AS 'Toplam Ogrenci Mevcudu' FROM ogrenci;
     */

    // 18) Öğrenci tablosunda kaç farklı isimde öğrenci olduğunu listeleyiniz.
    /*
    SELECT DISTINCT ograd FROM ogrenci;
     */

     // 19) En fazla sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.
    /*
    SELECT MAX(sayfasayisi) FROM kitap;
     */


    // 20) En fazla sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.
    /*
        SELECT kitapadi, sayfasayisi FROM kitap
        WHERE sayfasayisi = (SELECT MAX(sayfasayisi) FROM kitap);
         */

     // 21) En az sayfa sayısı olan kitabın sayfa sayısını listeleyiniz.
        // SELECT MIN(sayfasayisi) FROM kitap;

    // 22) En az sayfası olan kitabın adını ve sayfa sayısını listeleyiniz.
    /*
    SELECT kitapadi, sayfasayisi FROM kitap
    HAVING sayfasayisi = (SELECT MIN(sayfasayisi) FROM kitap);
     */

    // 23) Dram türündeki en fazla sayfası olan kitabın sayfa sayısını bulunuz.
    /*
    SELECT MAX(sayfasayisi) FROM kitap k
    INNER JOIN tur t
    ON k.turno=t.turno
    WHERE t.turadi='Dram';
     */

    // 24) numarası 15 olan öğrencinin okuduğu toplam sayfa sayısını bulunuz.
    /*
    SELECT SUM(sayfasayisi) FROM kitap k
    INNER JOIN islem i
    ON k.kitapno=i.kitapno
    WHERE i.ogrno=15;
     */


    // 25) İsme göre öğrenci sayılarının adedini bulunuz.(Örn: ali 5 tane, ahmet 8 tane )
    /*
    SELECT ograd, COUNT(ograd) FROM ogrenci
    GROUP BY ograd;
     */

    // 26) Her sınıftaki öğrenci sayısını bulunuz.
    /*
    SELECT sinif, COUNT(*) FROM ogrenci
    GROUP BY sinif;
     */

    // 27) Her sınıftaki erkek ve kız öğrenci sayısını bulunuz.
    /*
    SELECT sinif, cinsiyet, COUNT(cinsiyet) FROM ogrenci
    GROUP BY sinif, cinsiyet;
     */

    // 28) Her öğrencinin adını, soyadını ve okuduğu toplam sayfa sayısını büyükten küçüğe doğru listeleyiniz.
    /*
    SELECT ograd, ogrsoyad, SUM(sayfasayisi) AS 'toplamSayfa'
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno
    LEFT JOIN kitap k
    ON i.kitapno=k.kitapno
    GROUP BY o.ograd, o.ogrsoyad
    ORDER BY toplamSayfa DESC
     */

    // 29) Her öğrencinin okuduğu kitap sayısını getiriniz.
    /*
    SELECT o.ogrno, COUNT(kitapno) AS 'toplamKitap'
    FROM ogrenci o
    LEFT JOIN islem i
    ON o.ogrno=i.ogrno
    GROUP BY ogrno;
     */

}
