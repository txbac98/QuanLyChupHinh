
CREATE DATABASE IF NOT EXISTS QL_CHUPHINH CHARACTER SET 'UTF8' COLLATE 'UTF8_UNICODE_CI';

USE QL_CHUPHINH;


CREATE TABLE IF NOT EXISTS TAIKHOAN
(
 MANV VARCHAR(10),
 TENNV VARCHAR(50),
 MATKHAU VARCHAR(10),
 LOAINV VARCHAR(50)
 );
 
 
 
 CREATE TABLE IF NOT EXISTS PHIEUCHUP
(
 MAPC VARCHAR(10),
 MAKH VARCHAR(10),
 NGAYTAO VARCHAR(20),
 TRANGTHAI VARCHAR(50)
 );
 
 CREATE TABLE IF NOT EXISTS CHITIETPHIEUCHUP
(
 MAPC VARCHAR(10),
 SOANH VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS KHACHHANG
(
 MAKH VARCHAR(10),
 TENKH VARCHAR(50),
 NGAYSINH VARCHAR(20),
 SDT VARCHAR(20),
 EMAIL VARCHAR(20)
 );
 
 CREATE TABLE IF NOT EXISTS PHIEUTHANHTOAN
(
 MAPTT VARCHAR(10),
 MAPC VARCHAR(10),
 MAKH VARCHAR(10),
 MANV VARCHAR(10),
 SOANH VARCHAR(5),
 BHT VARCHAR(100),
 CTHT VARCHAR(100),
 CTUD VARCHAR(100),
 NGAYTAO VARCHAR(20),
 SOTIEN VARCHAR(50)
 );
 
 CREATE TABLE IF NOT EXISTS CHUONGTRINHUUDAI
 (
  MACTUD VARCHAR(10),
  MANV VARCHAR(10),
  TENCTUD VARCHAR(100),
  NGAYBATDAU VARCHAR(20),
  NGAYKETTHUC VARCHAR(20),
  NOIDUNG VARCHAR(1000),
  GIATRIUUDAI VARCHAR(10)
 );
 
 CREATE TABLE IF NOT EXISTS BANGHOACHTOAN
 (
  MABHT VARCHAR(10),
  MANV VARCHAR(10),
  TENBHT VARCHAR(100),
  NGAYTAO VARCHAR(20),
  HIEULUC VARCHAR(20)
 );
 
 CREATE TABLE IF NOT EXISTS CHITIETHOACHTOAN
 (
  MACTHT VARCHAR(10),
  MABHT VARCHAR(10),
  NOIDUNG VARCHAR(1000),
  GIA VARCHAR(20)
 );
 
 
 INSERT INTO `taikhoan`(`MANV`, `TENNV`, `MATKHAU`, `LOAINV`) VALUES ('admin','admin','admin','Ban lãnh đạo');
 















