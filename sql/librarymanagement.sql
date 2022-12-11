-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 11 Ara 2022, 17:21:27
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `librarymanagement`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `book_name` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `author_name` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `type` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `book_page_count` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `book_publishing_year` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `book_publishing_house` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `number_of_books` varchar(120) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `books`
--

INSERT INTO `books` (`id`, `book_name`, `author_name`, `type`, `book_page_count`, `book_publishing_year`, `book_publishing_house`, `number_of_books`) VALUES
(1, 'Karamazov Kardeşler', 'Dostoyevski', 'Roman', '650', 'Can Yayınları', '1886', '7'),
(2, 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 'test2');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `members`
--

CREATE TABLE `members` (
  `id` int(11) NOT NULL,
  `member_fullname` varchar(150) COLLATE utf8_turkish_ci NOT NULL,
  `member_phone` varchar(150) COLLATE utf8_turkish_ci NOT NULL,
  `member_address` varchar(150) COLLATE utf8_turkish_ci NOT NULL,
  `member_email` varchar(150) COLLATE utf8_turkish_ci NOT NULL,
  `member_gender` varchar(180) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `members`
--

INSERT INTO `members` (`id`, `member_fullname`, `member_phone`, `member_address`, `member_email`, `member_gender`) VALUES
(1, 'Sezgin Aslantaş', '0531 564 0632', 'İstanbul/Pendik', 'aslantasezginn@gmail.com', ''),
(3, 'beyza arıbaş', '05439451268', 'küçükyalı/maltepe', 'beyza.aribas@hotmail.com', 'Kadın'),
(4, 'Mertcan Aydın', '0555 555 55 55', 'İstanbul/Sarıyer', 'mertcanaydin@gmail.com', 'Male');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `on_loan`
--

CREATE TABLE `on_loan` (
  `id` int(11) NOT NULL,
  `on_loan_date` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `member_id` int(120) NOT NULL,
  `book_id` int(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `on_loan`
--
ALTER TABLE `on_loan`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `members`
--
ALTER TABLE `members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `on_loan`
--
ALTER TABLE `on_loan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
