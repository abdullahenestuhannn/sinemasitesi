-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.2.30-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- sinemasitesi için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `sinemasitesi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sinemasitesi`;

-- tablo yapısı dökülüyor sinemasitesi.dil
CREATE TABLE IF NOT EXISTS `dil` (
  `dil_id` int(11) NOT NULL AUTO_INCREMENT,
  `diladı` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- sinemasitesi.dil: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `dil` DISABLE KEYS */;
INSERT INTO `dil` (`dil_id`, `diladı`) VALUES
	(1, 'TÜRKÇE'),
	(2, 'İNGİLİZCE'),
	(3, 'RUSÇA'),
	(4, 'ALMANCA');
/*!40000 ALTER TABLE `dil` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.document
CREATE TABLE IF NOT EXISTS `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filepath` text NOT NULL DEFAULT '0',
  `filename` text NOT NULL DEFAULT '0',
  `filetype` text NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- sinemasitesi.document: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` (`id`, `filepath`, `filename`, `filetype`) VALUES
	(11, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'Analogo.png', 'image/png'),
	(12, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', '01.jpg', 'image/jpeg'),
	(13, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'download.jpg', 'image/jpeg'),
	(14, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'john.jpg', 'image/jpeg'),
	(15, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', '120.jpg', 'image/jpeg'),
	(17, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'ay.jpg', 'image/jpeg'),
	(18, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'shazam.jpg', 'image/jpeg'),
	(19, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', '3.jpg', 'image/jpeg'),
	(20, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'outlow.jpg', 'image/jpeg'),
	(22, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'irak.jpg', 'image/jpeg'),
	(23, 'C:\\Users\\ABDULLAH\\Documents\\NetBeansProjects\\sinemasitesi\\web\\upload', 'hobbit.jpg', 'image/jpeg');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.filmler
CREATE TABLE IF NOT EXISTS `filmler` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) DEFAULT NULL,
  `süre` varchar(50) DEFAULT NULL,
  `imdb` int(11) DEFAULT NULL,
  `yönetmen_id` int(11) DEFAULT NULL,
  `dil_id` int(11) DEFAULT NULL,
  `yapım_id` int(11) DEFAULT NULL,
  `acıklama` varchar(500) DEFAULT NULL,
  `sinemasalonu_id` int(11) DEFAULT NULL,
  `vizyon_tarihi` varchar(100) DEFAULT NULL,
  `document_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`film_id`),
  KEY `FK_filmler_dil_id` (`dil_id`),
  KEY `FK_filmler_sinemasalonu_id` (`sinemasalonu_id`),
  KEY `FK_filmler_yapım_id` (`yapım_id`),
  KEY `FK_filmler_yönetmen_id` (`yönetmen_id`),
  KEY `FK_filmler_document_id` (`document_id`),
  CONSTRAINT `FK_filmler_dil_id` FOREIGN KEY (`dil_id`) REFERENCES `dil` (`dil_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_filmler_document_id` FOREIGN KEY (`document_id`) REFERENCES `document` (`id`),
  CONSTRAINT `FK_filmler_sinemasalonu_id` FOREIGN KEY (`sinemasalonu_id`) REFERENCES `sinemasalonları` (`sinemasalonu_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_filmler_yapım_id` FOREIGN KEY (`yapım_id`) REFERENCES `yapım` (`yapım_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_filmler_yönetmen_id` FOREIGN KEY (`yönetmen_id`) REFERENCES `yönetmen` (`yönetmen_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- sinemasitesi.filmler: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `filmler` DISABLE KEYS */;
INSERT INTO `filmler` (`film_id`, `ad`, `süre`, `imdb`, `yönetmen_id`, `dil_id`, `yapım_id`, `acıklama`, `sinemasalonu_id`, `vizyon_tarihi`, `document_id`) VALUES
	(1, 'İntikam Saati', '111 dk', 6, 1, 1, 1, 'Yenilmezler serisinin 3. filmi olan Avengers Infinity War filminin ardından bir çok süper kahraman yok olmuştur. Artık dünyada neredeyse hiç bir şey için umut kalmamıştır', 1, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 13),
	(3, 'John Wick', '131 dk', 7, 2, 2, 1, 'Filmde Keanu Reevesin sadece ata binmesi değil aynı zamanda ninjalar ile savaşması da işlenecek. Tabi John Wick tüm bunları ve çok daha fazlasını kellesine konan 14 milyon dolarlık ödül yüzünden ona musallat olan sayısız katilden kaçmaya çalışırken yapacak', 2, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 14),
	(4, '120', '120 dk', 7, 3, 1, 2, 'Yaşları 12 – 17 arasında değişen 120 isimsiz kahraman çocuk... Cephaneyi sırtlanırlar, karlı dağlarda günlerce gecelerce yürürler', 5, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 15),
	(5, 'Ay Lav Yu', '112 dk', 6, 4, 1, 2, 'İbrahimin hayat serüveni Amerikaya kadar gidecektir. Jessica ile hayatlarını birleştirirler ve artık köyüne dönme vakti gelmiştir', 4, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR	', 17),
	(7, 'Shazam!', '132 dk', 7, 6, 2, 1, 'DC evreninin yapımı olan filmde genç Billy Batsonun başına gelenler anlatılıyor', 3, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 18),
	(8, '3 Aptal', '170 dk', 8, 7, 2, 4, 'Hindistanın en iyi mühendislik okuluna başlayan öğrencilerin hayatını anlatıyor özet olarak', 4, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 19),
	(9, 'Outlaw King', '121 dk', 7, 8, 1, 5, 'İngiltere kralı I. Edwardın Orta Çağ İskoçyasını işgal etme çalışması sırasında Robert the Brucenin verdiği o müthiç çaba gözler önüne seriliyor', 6, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 20),
	(10, 'Kurtlar Vadisi Irak', '122 dk', 6, 9, 1, 2, 'Üsteğmen Süleyman Aslan, Kuzey Irakta Çuval Hadisesini yaşamış on bir askerden biridir. Olanları askerlik onuruna yakıştıramayan üsteğmen ardında Polat Alemdara yazılmış bir mektup bırakarak intihar eder', 1, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 22),
	(11, 'Hobbit Beklenmedik Yolculuk', '169 dk', 7, 10, 1, 9, 'Ejder Smaugdan Ereborun kayıp Cüce Krallığını geri almak için giriştikleri bu macerada çirkin Goblinler, Orklar, öldürücü Warglar, Devasa Örümcekler ve İnanılmaz Büyücülerle dolu çılgın yollardan geçeceklerdir', 2, 'KORANA VİRÜSÜ NEDENİYLE ERTELENMİŞTİR', 23);
/*!40000 ALTER TABLE `filmler` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.film_tür
CREATE TABLE IF NOT EXISTS `film_tür` (
  `film_tür_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL DEFAULT 0,
  `tür_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`film_tür_id`),
  KEY `FK_film_tür_film_id` (`film_id`),
  KEY `FK_fim_tür_tür_id` (`tür_id`),
  CONSTRAINT `FK_film_tür_film_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fim_tür_tür_id` FOREIGN KEY (`tür_id`) REFERENCES `tür` (`tür_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;

-- sinemasitesi.film_tür: ~15 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `film_tür` DISABLE KEYS */;
INSERT INTO `film_tür` (`film_tür_id`, `film_id`, `tür_id`) VALUES
	(171, 1, 1),
	(172, 1, 3),
	(173, 3, 8),
	(174, 3, 10),
	(177, 5, 2),
	(178, 7, 2),
	(179, 8, 2),
	(180, 8, 5),
	(181, 9, 3),
	(182, 9, 9),
	(183, 10, 1),
	(184, 10, 9),
	(201, 11, 2),
	(202, 11, 5),
	(219, 4, 3),
	(220, 4, 4);
/*!40000 ALTER TABLE `film_tür` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.oynar
CREATE TABLE IF NOT EXISTS `oynar` (
  `oynar_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL DEFAULT 0,
  `oyuncu_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`oynar_id`),
  KEY `FK_oynar_film_id` (`film_id`),
  KEY `FK_oynar_oyuncu_id` (`oyuncu_id`),
  CONSTRAINT `FK_oynar_film_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_oynar_oyuncu_id` FOREIGN KEY (`oyuncu_id`) REFERENCES `oyuncu` (`oyuncu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8;

-- sinemasitesi.oynar: ~34 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `oynar` DISABLE KEYS */;
INSERT INTO `oynar` (`oynar_id`, `film_id`, `oyuncu_id`) VALUES
	(260, 1, 1),
	(261, 1, 2),
	(262, 1, 3),
	(263, 3, 4),
	(264, 3, 5),
	(270, 5, 6),
	(271, 5, 7),
	(272, 5, 8),
	(273, 5, 9),
	(274, 5, 12),
	(275, 7, 20),
	(276, 7, 21),
	(277, 7, 22),
	(278, 7, 23),
	(279, 7, 24),
	(280, 7, 25),
	(281, 8, 21),
	(282, 8, 22),
	(283, 8, 23),
	(284, 9, 23),
	(285, 9, 24),
	(286, 9, 25),
	(287, 10, 8),
	(288, 10, 9),
	(289, 10, 10),
	(290, 10, 11),
	(314, 11, 14),
	(315, 11, 19),
	(316, 11, 21),
	(344, 4, 6),
	(345, 4, 8),
	(346, 4, 9),
	(347, 4, 12),
	(348, 4, 13);
/*!40000 ALTER TABLE `oynar` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.oyuncu
CREATE TABLE IF NOT EXISTS `oyuncu` (
  `oyuncu_id` int(11) NOT NULL AUTO_INCREMENT,
  `adı` varchar(50) NOT NULL DEFAULT '0',
  `soyad` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`oyuncu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- sinemasitesi.oyuncu: ~25 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `oyuncu` DISABLE KEYS */;
INSERT INTO `oyuncu` (`oyuncu_id`, `adı`, `soyad`) VALUES
	(1, 'Chris', 'Evans'),
	(2, 'Mark', 'Ruffalo'),
	(3, 'Robert', 'Downey Jr.'),
	(4, 'Keanu', 'Reeves'),
	(5, 'Laurence', 'Fishburne'),
	(6, 'Burak', 'Sergen'),
	(7, 'Cansel', 'Elcin'),
	(8, 'Yasar', 'Abravaya'),
	(9, 'Özge', 'Özberk'),
	(10, 'Ayça', 'Damgaci'),
	(11, 'Cengiz', 'Bozkurt'),
	(12, 'Fadik Sevin', 'Atasoy'),
	(13, 'Muhammed', 'Akay'),
	(14, 'Jackie', 'Chan'),
	(15, 'Tao', 'Yin'),
	(16, 'Tian', 'Jing'),
	(17, 'Ye', 'Liu'),
	(18, 'Asher', 'Angel'),
	(19, 'Jack Dylan', 'Grazer'),
	(20, 'Mark', 'Strong'),
	(21, 'Aamir', 'Khan'),
	(22, 'Mona', 'Singh'),
	(23, 'Sharman', 'Joshi'),
	(24, 'Billy', 'Howle'),
	(25, 'Chris', 'Pine');
/*!40000 ALTER TABLE `oyuncu` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.sinemasalonları
CREATE TABLE IF NOT EXISTS `sinemasalonları` (
  `sinemasalonu_id` int(11) NOT NULL AUTO_INCREMENT,
  `salon_adı` varchar(50) NOT NULL DEFAULT '0',
  `şehir` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sinemasalonu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- sinemasitesi.sinemasalonları: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sinemasalonları` DISABLE KEYS */;
INSERT INTO `sinemasalonları` (`sinemasalonu_id`, `salon_adı`, `şehir`) VALUES
	(1, 'YEŞİL SİNEMA', 'MALATYA'),
	(2, 'FORUM İSTANBUL', 'İSTANBUL'),
	(3, 'FORUM MERSİN', 'MERSİN'),
	(4, 'CANPARK AVM', 'İSTANBUL'),
	(5, 'KAYSERİ OPTİMUM', 'KAYSERİ'),
	(6, 'MALATYA AVŞAR SİNEMALARI', 'MALATYA');
/*!40000 ALTER TABLE `sinemasalonları` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.tür
CREATE TABLE IF NOT EXISTS `tür` (
  `tür_id` int(11) NOT NULL AUTO_INCREMENT,
  `türadı` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tür_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- sinemasitesi.tür: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `tür` DISABLE KEYS */;
INSERT INTO `tür` (`tür_id`, `türadı`) VALUES
	(1, 'AKSİYON'),
	(2, 'KOMEDİ'),
	(3, 'DRAM'),
	(4, 'BİLİM KURGU'),
	(5, 'MACERA'),
	(6, 'GERİLİM'),
	(7, 'SUÇ'),
	(8, 'FANTASTİK'),
	(9, 'SAVAŞ'),
	(10, 'TARİH'),
	(11, 'BİYOGRAFİ');
/*!40000 ALTER TABLE `tür` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.uye
CREATE TABLE IF NOT EXISTS `uye` (
  `uye_id` int(11) NOT NULL AUTO_INCREMENT,
  `adi` varchar(50) NOT NULL DEFAULT '0',
  `soyad` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `sifre` varchar(50) NOT NULL DEFAULT '0',
  `admin` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`uye_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- sinemasitesi.uye: ~12 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `uye` DISABLE KEYS */;
INSERT INTO `uye` (`uye_id`, `adi`, `soyad`, `email`, `sifre`, `admin`) VALUES
	(1, 'adimn', 'admin', 'admin', '12345', 1),
	(2, 'leo', 'life', 'leo@gmail.com', '123456', 0),
	(3, 'furkan', 'polat', 'pf@gmail.com', '123456', 0),
	(5, 'ali', 'tuhan', 'alit@gmail.com', '123456', 0),
	(10, 'abdullah', 'tuhan', 'abdullah@hotmail.com', 'aetaetas', 0),
	(11, 'FURKAN', 'POLAT', 'fpolat@gmail.com', '123456', 0),
	(12, 'Ozan', 'Köse', 'ozan@gmail.com', 'ozn123', 0),
	(13, 'onur', 'akpinar', 'onur_44@hotmail.com', '123456', 0),
	(14, 'ali', 'tuhan', 'alituhan@hotmail.com', '123456', 0),
	(15, 'ali', 'veli', 'aliveli@hotmail.com', 'aliveli', 0),
	(16, 'ali', 'tuhan', 'aliveli@hotmail.com', '123456', 0),
	(17, 'hasan', 'tuhan', 'h@hotmail.com', '123456', 0),
	(18, 'abuzer', 'kadayıf', 'a@hotmail.com', 'abuzer', 0),
	(19, 'hasan', 'türk', 'hturk@hotmail.com', '123456', 0);
/*!40000 ALTER TABLE `uye` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.vizyona_gelecekler
CREATE TABLE IF NOT EXISTS `vizyona_gelecekler` (
  `vizyona_gelecekler_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `film_adı` varchar(50) NOT NULL DEFAULT '0',
  `vizyon_tarihi` varchar(80) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vizyona_gelecekler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- sinemasitesi.vizyona_gelecekler: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `vizyona_gelecekler` DISABLE KEYS */;
INSERT INTO `vizyona_gelecekler` (`vizyona_gelecekler_id`, `film_adı`, `vizyon_tarihi`) VALUES
	(1, 'RECEP İVEDİK 5', 'KORANA VİRÜSÜNDEN DOLAYI İLERİ BİR TARİHE ALINMIŞTIR');
/*!40000 ALTER TABLE `vizyona_gelecekler` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.yapım
CREATE TABLE IF NOT EXISTS `yapım` (
  `yapım_id` int(11) NOT NULL AUTO_INCREMENT,
  `ülkesi` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`yapım_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- sinemasitesi.yapım: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yapım` DISABLE KEYS */;
INSERT INTO `yapım` (`yapım_id`, `ülkesi`) VALUES
	(1, 'ABD'),
	(2, 'TÜRKİYE'),
	(3, 'ÇİN'),
	(4, 'HİNDİSTAN'),
	(5, 'İNGİLTERE'),
	(6, 'FRANSA'),
	(7, 'İTALYA'),
	(8, 'JAPONYA'),
	(9, 'YENİ ZELLANDA'),
	(10, 'AVUSTRULYA');
/*!40000 ALTER TABLE `yapım` ENABLE KEYS */;

-- tablo yapısı dökülüyor sinemasitesi.yönetmen
CREATE TABLE IF NOT EXISTS `yönetmen` (
  `yönetmen_id` int(11) NOT NULL AUTO_INCREMENT,
  `yönetmenadı` varchar(50) NOT NULL DEFAULT '0',
  `soyad` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`yönetmen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- sinemasitesi.yönetmen: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yönetmen` DISABLE KEYS */;
INSERT INTO `yönetmen` (`yönetmen_id`, `yönetmenadı`, `soyad`) VALUES
	(1, 'Anthony', 'Russo'),
	(2, 'Chad', 'Stahelski'),
	(3, 'Murat', 'Saraçoglu'),
	(4, 'Sermiyan', 'Midyat'),
	(5, 'Sheng', 'Ding'),
	(6, 'David F.', 'Sandberg'),
	(7, 'Rajkumar', 'Hirani'),
	(8, 'David', 'Mackenzie'),
	(9, 'Serdar', 'Akar'),
	(10, 'Peter', 'Jackson');
/*!40000 ALTER TABLE `yönetmen` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
