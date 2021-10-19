package com.yasintorun.poolManagement.business.constants;

import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.concretes.User;

public class Messages {

	public static String oldPasswordError = "Eski şifre hatalı";

	public static String passwordNotMatch = "Şifreler Uyuşmamaktadır";

	public static String allFieldRequired = "Tüm alanlar zorunludur";
	
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
	public static String userListed ="Kullanıcılar listelendi";
	public static String userUpdated = "Kullanıcı güncellendi";
	public static String userDeleted = "Kullanıcı silindi";
	
	//Pool message
	public static String poolAdded = "Havuz eklendi";
	public static String poolListed ="Havuzlar listelendi";
	public static String poolUpdated = "Havuz güncellendi";
	public static String poolDeleted = "Havuz silindi";
	
	//Pool Lane message
	public static String poolLaneAdded = "Havuz Şeridi eklendi";
	public static String poolLaneListed ="Havuz şeritleri listelendi";
	public static String poolLaneUpdated = "Havuz şeridi güncellendi";
	public static String poolLaneDeleted = "Havuz şeridi silindi";

	//Auth message
	public static String emailInCorrect = "Eposta hatalı";
	public static String passwordInCorrect = "Şifre hatalı";
	public static String registerSuccessfully = "Kayıt başarılı";
	public static String registerFailed = "Kayıt başarısız";

	public static String loginSuccessfuly = "Giriş başarılı";

	public static String emailUsed = "Eposta zaten kayıtlı";

	public static String accountNotFind = "Böyle bir hesap yok";

	public static String passwordChangeSuccessFully = "Şifre başarıyla değiştirildi";

	public static String userNotFound = "Kullanıcı bulunamadı";

	public static String userGot = "Kullanıcı getirildi";



}
