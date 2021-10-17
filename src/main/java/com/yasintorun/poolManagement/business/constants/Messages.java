package com.yasintorun.poolManagement.business.constants;

import com.yasintorun.poolManagement.entities.concretes.Account;

public class Messages {

	//Global Message
	public static String errorOccurred = "Hata Oluştu";
	
	//Account message
	public static String accountListed = "Tüm hesaplar listelendi";
	public static String accountAdded ="Hesap eklendi";
	public static String accountUpdated = "Hesap güncellendi";
	public static String accountDeleted = "Hesap silindi";
	public static String accountGetByEmail = "Eposta adresine göre hesap getirildi";
	public static String accountNotFound = "Hesap bulunamadı";
	
	//User message
	public static String userAdded = "Kullanıcı eklendi";
	public static String userListed ="Kullanıcı listelendi";
	public static String userUpdated = "Kullanıcı güncellendi";
	public static String userDeleted = "Kullanıcı silindi";

	//Auth message
	public static String emailInCorrect = "Eposta hatalı";
	public static String passwordInCorrect = "Şifre hatalı";
	public static String registerSuccessfully = "Kayıt başarılı";
	public static String registerFailed = "Kayıt başarısız";

	public static String loginSuccessfuly = "Giriş başarılı";

	public static String emailUsed = "Eposta zaten kayıtlı";



}
