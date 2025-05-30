# 📆 Ödev 4 – Etkinlik Planlayıcı Uygulaması

Bu proje, Android Bootcamp kapsamında verilen **"Çoklu Sayfa Geçişleri ve Geri Tuşu Yönetimi"** ödevi için geliştirilmiştir.

## 🧠 Senaryo

Uygulama, bir **etkinlik planlayıcı** senaryosu üzerinden tasarlanmıştır. Kullanıcılar bireysel veya grup etkinlikleri için seçim yaparak adım adım planlama yapabilir.

## 📱 Sayfa Yapısı

- **Ana Sayfa**  
  Kullanıcıya "Grup Planla" ve "Bireysel Planla" seçenekleri sunar.

- **Sayfa A – Grup Etkinlik Detayı**  
  Grup etkinliği için detaylı bilgiler seçilir.

- **Sayfa B – Kişi Sayısı Seçimi**  
  Etkinliğe katılacak kişi sayısı belirlenir.

- **Sayfa X – Bireysel Etkinlik Detayı**  
  Bireysel etkinlik detayları girilir.

- **Sayfa Y – Onay Sayfası**  
  Etkinlik kaydının başarıyla yapıldığını belirten bilgi ekranı.  
  Geri tuşuna basıldığında **doğrudan Ana Sayfa**ya yönlendirilir.

## 🔄 Navigasyon Akışı

<p align="center">
  <img src="app/src/main/res/drawable/odev_akis.png" width="600" />
</p>

> Bu diyagram, ödev kapsamındaki yönlendirme mantığını özetler.

## 🛠️ Kullanılan Özellikler

- Navigation Component ile sayfa geçişleri
- Geri tuşu kontrolü
- RadioButton ile seçim yapma
- MaterialDatePicker & TimePicker kullanımı
- Exposed Dropdown Menu ile etkinlik türü seçimi
- Temel UI bileşenleri (Button, TextView)
- Karanlık tema desteği
- Türkçe dil desteği

## 📸 Ekran Görüntüleri

<p align="center">
  <img src="app/src/main/res/drawable/anasayfa.png" width="180" />
  <img src="app/src/main/res/drawable/grup_detay.png" width="180" />
  <img src="app/src/main/res/drawable/kisi_sec.png" width="180" />
</p>
<p align="center">
  <img src="app/src/main/res/drawable/koyu_mod.png" width="180" />
  <img src="app/src/main/res/drawable/liste.png" width="180" />
  <img src="app/src/main/res/drawable/basarili_mesaj.png" width="180" />
</p>
