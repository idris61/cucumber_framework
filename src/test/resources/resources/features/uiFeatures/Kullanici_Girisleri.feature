@Kullanici_Giris
Feature: Kullanici Girisleri ve Kullanici olusturma

  @User_Giris
  Scenario: User Girisi

    Given User girisi yapilir
    Then IG Sign out butonuna tiklanir
    And IG Sayfa kapatilir


  @Personel_Giris
  Scenario: Personel Girisi

    Given Personel girisi yapilir
    Then IG Sign out butonuna tiklanir
    And IG Sayfa kapatilir


  @Hasta_Giris
  Scenario: Hasta Girisi

    Given Hasta girisi yapilir
    Then IG Sign out butonuna tiklanir
    And IG Sayfa kapatilir


  @Doctor_Giris
  Scenario: Doktor Girisi

    Given Doktor girisi yapilir
    Then IG Sign out butonuna tiklanir
    And IG Sayfa kapatilir

  @Admin_Giris
  Scenario: Admin Girisi

    Given Admin girisi yapilir
    Then IG Sign out butonuna tiklanir
    And IG Sayfa kapatilir

  @User_Olusturma
  Scenario: Admin girisi ile user olusturma

    Given Olusturulacak User bilgileri girilir

