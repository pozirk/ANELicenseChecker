del android\SAMLicenseChecker\build\libLicenseChecker.jar

del SAMLicenseChecker.ane

xcopy android\SAMLicenseChecker\bin\classes android\SAMLicenseChecker\bin /S /Y /R

rd android\SAMLicenseChecker\bin\classes /S /Q

"c:\Program Files (x86)\Java\jdk1.7.0_13\bin\jar.exe" cvf android/SAMLicenseChecker/build/libLicenseChecker.jar -C android/SAMLicenseChecker/bin .

SET PLATFORM_ANDROID= -platform Android-ARM -C android\SAMLicenseChecker\build\ .
SET PLATFORM_DEFAULT= -platform default -C default\ .

"c:\Program Files (x86)\Adobe\AIR3.7\bin\adt.bat" -package -target ane SAMLicenseChecker.ane air/extension.xml -swc air/LicenseChecker/bin/LicenseChecker.swc %PLATFORM_ANDROID% %PLATFORM_DEFAULT%