del android\LicenseChecker\build\libLicenseChecker.jar

del LicenseChecker.ane

xcopy android\LicenseChecker\bin\classes android\LicenseChecker\bin /S /Y /R

rd android\LicenseChecker\bin\classes /S /Q

"c:\Program Files (x86)\Java\jdk1.7.0_13\bin\jar.exe" cvf android/LicenseChecker/build/libLicenseChecker.jar -C android/LicenseChecker/bin .

SET PLATFORM_ANDROID= -platform Android-ARM -C android\LicenseChecker\build\ .
SET PLATFORM_DEFAULT= -platform default -C default\ .

"c:\Program Files (x86)\Adobe\AIR3.7\bin\adt.bat" -package -target ane LicenseChecker.ane air/extension.xml -swc air/LicenseChecker/bin/LicenseChecker.swc %PLATFORM_ANDROID% %PLATFORM_DEFAULT%