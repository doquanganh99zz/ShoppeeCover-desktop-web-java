﻿CREATE DATABASE SHOPOFQA;
DROP DATABASE SHOPOFQA
GO
USE SHOPOFQA;
USE MASTER;
-----------------------------HỦY BẢNG--------------------------------
GO
DROP TABLE BILLDETAIL;
DROP TABLE SALES;
DROP TABLE BILL;
DROP TABLE SHIPMETHOD;
DROP TABLE BUYMETHOD;
DROP TABLE CANCELREASON;
DROP TABLE ACCOUNTBAG;
DROP TABLE PROPERTYDETAIL;
DROP TABLE PROPERTY;
DROP TABLE PRODUCTTYPEDETAIL;
DROP TABLE TYPEDETAIL;
DROP TABLE VOTESTAR;
DROP TABLE PRODUCT;
DROP TABLE SHOP;
DROP TABLE ADDRESSTB;
DROP TABLE ACCOUNTSHIPCONTACT;
DROP TABLE ACCOUNT;
DROP TABLE SEX;
DROP TABLE ACCOUNTSTATUS;
-----------------------------TẠO BẢNG--------------------------------
--BẢNG GIỚI TÍNH
GO
CREATE TABLE SEX
(
    SEXID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    SEXCODE VARCHAR(15)
        UNIQUE NOT NULL,
    SEXDETAIL NVARCHAR(15)
        UNIQUE NOT NULL
);
--BẢNG TRẠNG THÁI TÀI KHOẢN
--CÓ 2 TRẠNG THÁI KHÓA VÀ BÌNH THƯỜNG
GO
CREATE TABLE ACCOUNTSTATUS
(
    ACCOUNTSTATUSID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTSTATUSCODE VARCHAR(15)
        UNIQUE NOT NULL,
    ACCOUNTSTATUSDETAIL NVARCHAR(15)
        UNIQUE NOT NULL
);
--BẢNG TÀI KHOẢN NGƯỜI DÙNG
GO
CREATE TABLE ACCOUNT
(
    ACCOUNTID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTEMAIL VARCHAR(30)
        DEFAULT NULL,
    ACCOUNTUSERNAME VARCHAR(30)
        DEFAULT NULL,
    ACCOUNTNUMBERPHONE VARCHAR(15)
        DEFAULT NULL,
    ACCOUNTPASSWORD VARCHAR(16) NOT NULL,
    ACCOUNTSTATUSID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.ACCOUNTSTATUS (ACCOUNTSTATUSID),
    ACCOUNTSEXID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.SEX (SEXID),
    ACCOUNTNAME NVARCHAR(50)
        DEFAULT NULL,
    ACCOUNTBORN DATE
        DEFAULT NULL,
    ACCOUNTADDRESS NVARCHAR(50)
        DEFAULT NULL,
    ACCOUNTDETAILADDRESS NVARCHAR(MAX)
        DEFAULT NULL,
    ACCOUNTPHONENUMBER VARCHAR(15)
        DEFAULT NULL,
    ACCOUNTWALLET INT CHECK (ACCOUNTWALLET >= 0)
        DEFAULT 0,
    ACCOUNTCREATEDATE DATETIME
        DEFAULT GETDATE()
);
--BẢNG ĐỊA CHỈ VÀ LIÊN HỆ NHẬN HÀNG
GO
CREATE TABLE ACCOUNTSHIPCONTACT
(
    ACCOUNTSHIPCONTACTID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.ACCOUNT (ACCOUNTID),
    RECEIVERNAME NVARCHAR(30) NOT NULL,
    PROVINCE NVARCHAR(30) NOT NULL,
    DISTRICT NVARCHAR(30) NOT NULL,
    COMMUNEORWARD NVARCHAR(30) NOT NULL,
    ACCOUNTDETAILADDRESS NVARCHAR(MAX) NOT NULL,
    ACCOUNTPHONENUMBER VARCHAR(15) NOT NULL,
);
--BẢNG ĐỊA CHỈ
GO
CREATE TABLE ADDRESSTB
(
ADDRESSTBID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ADDRESSTBCODE VARCHAR(15) NOT NULL UNIQUE,
ADDRESSTBNAME NVARCHAR(30) NOT NULL UNIQUE
)
--BẢNG CỬA HÀNG
GO
CREATE TABLE SHOP
(
    SHOPID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTID UNIQUEIDENTIFIER
        FOREIGN KEY REFERENCES DBO.ACCOUNT (ACCOUNTID),
    SHOPNAME NVARCHAR(30)
        UNIQUE NOT NULL,
		ADDRESSTBID UNIQUEIDENTIFIER NOT NULL FOREIGN KEY REFERENCES DBO.ADDRESSTB(ADDRESSTBID)
);
--BẢNG LOẠI SẢN PHÂM
GO
CREATE TABLE TYPEDETAIL
(
    TYPEDETAILID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    TYPEDETAILCODE VARCHAR(15)
        UNIQUE NOT NULL,
    TYPEDETAILNAME NVARCHAR(30)
        UNIQUE NOT NULL
);
--BẢNG SẢN PHẨM
GO
CREATE TABLE PRODUCT
(
    PRODUCTID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    SHOPID UNIQUEIDENTIFIER
        FOREIGN KEY REFERENCES DBO.SHOP (SHOPID),
    PRODUCTNAME NVARCHAR(30) NOT NULL,
    PRODUCER NVARCHAR(30) NOT NULL,
    PRODUCTDETAIL NVARCHAR(MAX) NOT NULL
);
--BẢNG VOTE SAO
GO 
CREATE TABLE VOTESTAR
(
VOTESTARID UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
PRODUCTID UNIQUEIDENTIFIER NOT NULL FOREIGN KEY REFERENCES DBO.PRODUCT(PRODUCTID),
ACCOUNTID UNIQUEIDENTIFIER NOT NULL FOREIGN KEY REFERENCES DBO.ACCOUNT(ACCOUNTID),
STARVOTED INT DEFAULT NULL
)
--BẢNG DANH SÁCH THỂ LOẠI CỦA SẢN PHẨM
GO
CREATE TABLE PRODUCTTYPEDETAIL
(
    PRODUCTTYPEDETAILID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    PRODUCTID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.PRODUCT (PRODUCTID),
    TYPEDETAILID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.TYPEDETAIL (TYPEDETAILID)
);
--BẢNG DANH SÁCH THUỘC TÍNH SẢN PHẨM
GO
CREATE TABLE PROPERTY
(
    PROPERTYID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    PRODUCTID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.PRODUCT (PRODUCTID),
    PROPERTYNAME NVARCHAR(30) NOT NULL,
    PROPERTYSORT INT
        DEFAULT 1
);
--BẢNG CHI TIẾT THUỘC TÍNH SẢN PHẨM
GO
CREATE TABLE PROPERTYDETAIL
(
    PROPERTYDETAILID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    PROPERTYID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.PROPERTY (PROPERTYID),
    PARENTID UNIQUEIDENTIFIER
        DEFAULT NULL,
    PROPERTYIMG IMAGE
        DEFAULT NULL,
    PROPERTYDETAILNAME NVARCHAR(30) NOT NULL,
    QUANTITY INT CHECK (QUANTITY >= 0)
        DEFAULT 0,
    PRICE INT CHECK (PRICE >= 0)
        DEFAULT 0,
    SHELLPRICE INT CHECK (SHELLPRICE >= 0)
        DEFAULT 0
);
--BẢNG GIỎ HÀNG CHỜ LÊN ĐƠN CỦA ACCOUNT
GO
CREATE TABLE ACCOUNTBAG
(
    ACCOUNTBAG UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.ACCOUNT (ACCOUNTID),
    PROPERTYDETAILID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.PROPERTYDETAIL (PROPERTYDETAILID),
    QUANTITY INT CHECK (QUANTITY >= 1)
        DEFAULT 1
);
--BẢNG PHƯƠNG THỨC THANH TOÁN
GO
CREATE TABLE BUYMETHOD
(
    BUYMETHODID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    BUYMETHODCODE VARCHAR(15)
        UNIQUE NOT NULL,
    BUYMETHODNAME NVARCHAR(30)
        UNIQUE NOT NULL
);
--BẢNG PHƯƠNG THỨC VẬN CHUYỂN
GO
CREATE TABLE SHIPMETHOD
(
    SHIPMETHODID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    SHIPMETHODCODE VARCHAR(15)
        UNIQUE NOT NULL,
    SHIPMETHODNAME NVARCHAR(30)
        UNIQUE NOT NULL
);
--BẢNG LÝ DO HỦY
--BẢNG NÀY SẼ LÀ KHÓA PHỤ NẾU ĐƠN BỊ HỦY NHƯNG KHÔNG TẠO RÀNG BUỘC VỚI BẢNG HÓA ĐƠN VÌ ĐƠN CÓ TRẠNG THÁI CHỈ KHI VÀ CHỈ KHI HỦY ĐƠN CỘT LÝ DO HỦY (CANCELREASONID) MỚI CÓ LINK CÒN TRẠNG THÁI CHỜ NHẬN HÀNG VÀ NHẬN HÀNG THÀNH CÔNG ĐÃ THANH TOÁN SẼ FIX CỨNG CỘT LẠI KO CHO SỬA NỮA.
GO
CREATE TABLE CANCELREASON
(
    CANCELREASONID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    CANCELREASONCODE VARCHAR(15)
        UNIQUE NOT NULL,
    CANCELREASONNAME NVARCHAR(50)
        UNIQUE NOT NULL
);
--BẢNG HÓA ĐƠN
--HÓA ĐƠN CÓ 3 TRẠNG THÁI CHỜ NHẬN HÀNG, ĐÃ NHẬN HÀNG VÀ BỊ HỦY
--HÓA ĐƠN VỚI HÓA ĐƠN MÀ PHƯƠNG THỨC THANH TOÁN TRỰC TIẾP TRÊN ỨNG DỤNG LÀ CHUYỂN KHOẢN HAY HOẶC DẠNG THANH TOÁN TRỰC TIẾP KHI TẠO HÓA ĐƠN THÌ HÓA ĐƠN VẪN SẼ Ở DẠNG CHỜ VÌ NGƯỜI DÙNG CÓ THỂ HỦY ĐƠN VÌ THẾ TIỀN SẼ TREO TRÊN HÓA ĐƠN CHỜ KHI BỊ HỦY CHUYỂN TRẠNG THÁI HÓA ĐƠN VÀ FIX CỨNG TOÀN BỘ THÔNG TIN TỪ KHI KHỞI TẠO HÓA ĐƠN HOÀN TRẢ TIỀN CHO NGƯỜI DÙNG TRẢ LẠI HÀNG CHO SHOP ĐÚNG VỚI TIỀN VÀ SỐ LƯỢNG KHI TẠO. CÁC TRẠNG THÁI THANH TOÁN KỂ TRÊN TIỀN ĐƯỢC CỘNG CHO SHOP BỊ TRỪ Ở NGƯỜI DÙNG VÀ SỐ LƯỢNG HÀNG MUA BỊ TRỪ TỪ KHO SHOP SẼ ĐƯỢC COMMIT KHI HÓA ĐƠN ĐƯỢC CHỐT LÀ ĐÃ NHẬN HÀNG ĐỒNG THỜI CHUYỂN TRẠNG THÁI HÓA ĐƠN FIX CỨNG TOÀN BỘ THÔNG TIN.
--TRẠNG THÁI 0 LÀ ĐANG CHỜ NHẬN HÀNG
--TRẠNG THÁI 1 LÀ ĐÃ NHẬN HÀNG
--TRẠNG THÁI 2 LÀ HỦY ĐƠN
--HÓA ĐƠN KHỞI TẠO MẶC ĐỊNH LÀ TRẠNG THÁI CHỜ NHẬN HÀNG == 0
GO
CREATE TABLE BILL
(
    BILLID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    ACCOUNTSHIPCONTACTID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.ACCOUNTSHIPCONTACT (ACCOUNTSHIPCONTACTID),
    BUYMETHODID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.BUYMETHOD (BUYMETHODID),
    SHIPMETHOD UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.SHIPMETHOD (SHIPMETHODID),
    CREATEDATE DATETIME NOT NULL
        DEFAULT GETDATE(),
    SHIPTOBUYERDATE DATE
        DEFAULT NULL,
    BILLSTATUS INT
        DEFAULT 0,
    RECEIVEDDATE DATE
        DEFAULT NULL,
    CANCELDATE DATETIME
        DEFAULT NULL,
    CANCELREASON UNIQUEIDENTIFIER
        DEFAULT NULL,
    BUYERNOTIFICATION NVARCHAR(MAX)
        DEFAULT NULL
);
--BẢNG VOUCHER SỰ KIỆN 
--BẢNG NÀY QUYẾT ĐỊNH GIÁ BÁN CHÍNH THỨC CỦA SẢN PHẨM CÓ 2 THAM SỐ CHÍNH TÁC ĐỘNG GIÁ LÀ GIẢM THEO % HOẶC TRỪ VÀO TỔNG TIỀN THANH TOÁN
--MẶC ĐỊNH KHÔNG CÓ GIẢM GIÁ THÌ SẼ BẮT VÀO BẢN GHI KHÔNG CÓ GIÁ TRỊ Ở 2 THAM SỐ TÁC ĐỘNG TỔNG TIỀN THANH TOÁN
GO
CREATE TABLE SALES
(
    SALESID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    SALESCODE VARCHAR(15)
        UNIQUE NOT NULL,
    SALESNAME NVARCHAR(30)
        UNIQUE NOT NULL,
    SALESPERSEN INT CHECK (SALESPERSEN >= 0)
        DEFAULT 0,
    SALESINT INT CHECK (SALESINT >= 0)
        DEFAULT 0
);
--BẢNG HÓA ĐƠN CHI TIẾT
GO
CREATE TABLE BILLDETAIL
(
    BILLDETAILID UNIQUEIDENTIFIER PRIMARY KEY
        DEFAULT NEWID(),
    BILLID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.BILL (BILLID),
    PROPERTYDETAILID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.PROPERTYDETAIL (PROPERTYDETAILID),
    SALESID UNIQUEIDENTIFIER NOT NULL
        FOREIGN KEY REFERENCES DBO.SALES (SALESID),
    QUANTITY INT CHECK (QUANTITY >= 1)
        DEFAULT 1,
    PRICE INT
        DEFAULT NULL
);


--------------------------------THÊM DỮ LIỆU MẶC ĐỊNH------------------------------------
--BẢNG GIỚI TÍNH
INSERT INTO DBO.SEX
(
    SEXID,
    SEXCODE,
    SEXDETAIL
)
VALUES
('12C8761C-4AE2-4A39-AD3F-F573DE15C85D', 'GT01', N'NAM'),
('383883F9-BC5D-4514-A417-A85F091724A4', 'GT02', N'NỮ'),
('E68C67E6-CA3E-4208-B23D-FF6092E56ACC', 'GT03', N'KHÔNG XÁC ĐỊNH');
--BẢNG TRẠNG THÁI TÀI KHOẢN NGƯỜI DÙNG
INSERT INTO DBO.ACCOUNTSTATUS
(
    ACCOUNTSTATUSID,
    ACCOUNTSTATUSCODE,
    ACCOUNTSTATUSDETAIL
)
VALUES
('C506315C-FC60-4CC7-87E3-DDDA16F8780A', 'TT01', N'BÌNH THƯỜNG'),
('3825AD40-583B-49A6-8888-829F13FB17E1', 'TT02', N'BỊ KHÓA');
--BẢNG PHÂN LOẠI SẢN PHẨM
INSERT INTO DBO.TYPEDETAIL
(
    TYPEDETAILID,
    TYPEDETAILCODE,
    TYPEDETAILNAME
)
VALUES
('B25C79A1-0706-4C02-956E-02BFF37CEECF', 'TD01', N'GIA ĐÌNH'),
('53CE2424-4EC3-4254-A74A-4E2CBB93CAE1', 'TD02', N'THIẾT BỊ ĐIỆN TỬ'),
('A9F8DCC9-79DC-4CA6-8B65-63D913906365', 'TD03', N'XE CỘ'),
('AD0C26D9-2807-40EE-8EFB-7B372E86C12F', 'TD04', N'THỜI TRANG NỮ'),
('2A9A2917-27A6-4836-AEDA-31CE3FE61237', 'TD05', N'THỜI TRANG NAM'),
('063704D4-EBDA-4438-AD5E-4746FDC5DA51', 'TD06', N'SẮC ĐẸP'),
('2DFDDBCD-5F68-4C7A-9E87-92109D499984', 'TD07', N'MẸ & BÉ'),
('DA97D087-FF4D-40C3-96BA-54EDD3EDCB57', 'TD08', N'NHÀ SÁCH ONLINE'),
('AA38EC98-C9B7-4A2C-BD6F-FC129C3DFF53', 'TD09', N'SỨC KHỎE'),
('0D218A98-BC34-4D3E-A302-1647203B01FD', 'TD10', N'MÁY TÍNH & LAPTOP'),
('EE19CFED-4D9F-425E-85C9-A6D15F7DF98B', 'TD11', N'ĐIỆN THOẠI & PHỤ KIỆN'),
('B3DA0A14-F2CB-45E5-B91B-1D7C0757BD29', 'TD12', N'ĐỒNG HỒ'),
('D2E9344C-1D95-4D73-9919-D63BEA039358', 'TD13', N'THỜI TRANG'),
('C502905C-C090-4FAA-9961-BC95204757BB', 'TD14', N'GIÀY DÉP NAM'),
('19D29702-A1A7-4147-A1D9-5CF3260127F2', 'TD15', N'GIÀY DÉP NỮ'),
('F05DDED8-A1FE-4946-B5FB-5BFB043C2BD5', 'TD16', N'GIÀY DÉP'),
('7944E5E6-B2C8-4A75-9EAF-C9F7FC389B94', 'TD17', N'THIẾT BỊ ĐIỆN GIA DỤNG'),
('B8AB066B-0234-4724-A72E-4A6DE2109DBA', 'TD18', N'NHÀ CỬA & ĐỜI SỐNG'),
('BA55ACF4-9B6E-481D-9119-13C1A0722A1A', 'TD19', N'ĐỒ CHƠI CÔNG NGHỆ'),
('0A621930-6F68-4439-BD0D-5EB5C1160615', 'TD20', N'TRANG SỨC NỮ'),
('3CE95EF6-01C2-4359-8333-DC98C17F2332', 'TD21', N'PHỤ KIỆN NAM'),
('193AB49E-3E2F-473C-9533-880246FD977F', 'TD22', N'PHỤ KIỆN'),
('44A02DA3-0B6D-4EF6-8D7B-70C52D539A6C', 'TD23', N'MÁY ẢNH & QUAY PHIM'),
('3A6E59F3-5046-478A-90F5-F0C970902FF7', 'TD24', N'THỜI TRANG TRẺ EM'),
('B7920C58-5662-4F8B-9FCC-FDAF38DFD55A', 'TD25', N'TRẺ EM'),
('4BE2E980-6F31-4875-A9DF-D3EDFBFDE9E8', 'TD26', N'ĐỒ CHƠI'),
('90C910C7-1AC7-4537-A52E-F4FC075D5A27', 'TD27', N'THÚ CƯNG'),
('255272C1-20D3-46E7-B12E-8207AD0BFF94', 'TD28', N'THỂ THAO & DU LỊCH'),
('43F94554-E43D-483D-A180-B9D3A4B30AE9', 'TD29', N'FOOD & DRINK');
--BẢNG PHƯƠNG THỨC THANH TOÁN
INSERT INTO DBO.BUYMETHOD
(
    BUYMETHODID,
    BUYMETHODCODE,
    BUYMETHODNAME
)
VALUES
('555EEAA4-8684-4945-8ACB-08520E734ABB', 'PTB01', N'THANH TOÁN KHI NHẬN HÀNG'),
('ED424B60-BD77-4073-87C9-339FC1D5251D', 'PTB02', N'SỬ DỤNG SHOPPEECOIN'),
('05CCD3AD-AEAB-451A-A0B8-9DC516A95B5D', 'PTB03', N'INTENETBANKING'),
('5FB355F3-FBF7-4344-A126-0749AF7D0D69', 'PTB04', N'SỬ DỤNG THẺ THANH TOÁN NỘI ĐỊA');
--BẢNG PHƯƠNG THỨC GIAO HÀNG
INSERT INTO DBO.SHIPMETHOD
(
    SHIPMETHODID,
    SHIPMETHODCODE,
    SHIPMETHODNAME
)
VALUES
('5D0C34E3-4FF2-4601-B864-92C0E62E1CB6', 'PTS01', N'CHUYỂN PHÁT NHANH'),
('5D5CD22F-60ED-4496-B43B-91AD2CDB866C', 'PTS02', N'CHUYỂN PHÁT THƯỜNG'),
('916B6A31-E69A-4EDD-A7F0-4396B631400E', 'PTS03', N'HỎA TỐC');
--BẢNG LÝ DO HỦY
INSERT INTO DBO.CANCELREASON
(
    CANCELREASONID,
    CANCELREASONCODE,
    CANCELREASONNAME
)
VALUES
('9D2551A3-C230-418F-9EB9-86BE2F94B9E4', 'CR01', N'GIAO HÀNG MUỘN'),
('84C0ED3E-1AB8-4BE8-8B02-F65CE4554EB9', 'CR02', N'THAY ĐỔI PHƯƠNG THỨC THANH TOÁN'),
('F5EDB481-E862-4E85-965C-3FD315E838DE', 'CR03', N'THAY ĐỔI ĐỊA CHỈ NHẬN HÀNG'),
('06F14409-6758-4DAD-9E14-ED51E7D9F95D', 'CR04', N'THAY ĐỔI SỐ LƯỢNG'),
('DA7E1F17-9FD4-49BA-9991-A11F8809BC86', 'CR05', N'SẢN PHẨM KHÔNG ĐÚNG MÔ TẢ'),
('0658AFBD-F1E6-4480-8CB0-6AC2EDA89AA3', 'CR06', N'ĐỔI Ý KHÔNG MUA NỮA'),
('C4CDC709-EF43-494D-B0FF-202C4DC9DCDE', 'CR07', N'TÌM ĐƯỢC CHỖ KHÁC RẺ HƠN');
--BẢNG ĐỊA CHỈ
INSERT INTO DBO.ADDRESSTB
(
    ADDRESSTBID,
    ADDRESSTBCODE,
    ADDRESSTBNAME
)
VALUES
('0CCCCB5B-A44E-4AF2-8209-921F63D10EFB','HN',N'HÀ NỘI'),
('644A7E6D-173F-4A6A-99ED-5554637622F1','TPHCM',N'TP HỒ CHÍ MINH'),
('CBDB1091-71F5-488D-8642-D729AC46F102','HP',N'HẢI PHÒNG'),
('EBD7D256-AE3B-4072-AEF6-15A1DA065562','TB',N'THÁI BÌNH'),
('CC5103CF-5551-4861-B0A2-54C7B9015DF4','ND',N'NAM ĐỊNH'),
('49E445C9-30DF-4D7F-8A66-3147A26CB206','NN',N'NƯỚC NGOÀI'),
('9D2FF4C0-8B74-41E9-ABE1-BA2419E1093F','DN',N'ĐÀ NẴNG'),
('DAC779AD-EDEF-43B2-BAEC-48E2EC84FDB8','TN',N'THÁI NGUYÊN'),
('DC72469B-E76F-421A-BB56-0C110312415A','CT',N'CẦN THƠ')

SELECT * FROM DBO.ACCOUNTSTATUS
SELECT * FROM DBO.SEX
SELECT * FROM DBO.CANCELREASON
SELECT * FROM DBO.BUYMETHOD
SELECT * FROM DBO.SHIPMETHOD
SELECT * FROM DBO.TYPEDETAIL
SELECT * FROM DBO.ADDRESSTB
