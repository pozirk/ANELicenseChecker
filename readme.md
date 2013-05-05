# About
Application Licensing is an Adobe AIR native extension (ANE) for Android that works with Google Play and Samsung Apps (Zirconia).


# Docs
http://help.adobe.com/en_US/air/extensions/index.html
http://developer.android.com/google/play/licensing/index.html
http://developer.samsung.com/android/technical-docs/How-to-protect-your-app-from-illegal-copy-using-Samsung-Application-License-Management-Zirconia


# Installation
For Google Play: add "LicenseChecker.ane" and "air\LicenseChecker\bin\LicenseChecker.swc" to your AIR project
For Samsung Apps: add "SAMLicenseChecker.ane" and "air\LicenseChecker\bin\LicenseChecker.swc" to your AIR project

Add the following lines to your AIR Aplication-app.xml file inside <manifestAdditions> section:
For Google Play;
<uses-permission android:name="com.android.vending.CHECK_LICENSE" />

For Samsung Apps:
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE" />


# Example for Google Play
import com.pozirk.license.android.LicenseChecker;
import com.pozirk.license.android.LicenseCheckerEvent;


//> initialization
try
{
	_checker = new LicenseChecker();
	_checker.addEventListener(LicenseCheckerEvent.LICENSED, onLicensed);
	_checker.addEventListener(LicenseCheckerEvent.NOT_LICENSED, onNotLicensed);
	_checker.addEventListener(LicenseCheckerEvent.APPLICATION_ERROR, onAppError);
}
catch(err:Error)
{
	...
}
//<

//checking license
_checker.check("YOUR_LICENSE_KEY_FOR_THE_APPLICATION"); //you can find it in your app's "Services and APIs" at developer's dahsboard


protected function onLicensed(event:LicenseCheckerEvent):void
{
	if(int(event.data) == LicenseCheckerEvent.OK)
		... //everything is ok
}

protected function onNotLicensed(event:LicenseCheckerEvent):void
{
	if(int(event.data) == LicenseCheckerEvent.RETRY)
		... //probably there is no internet connection, read more info in docs
	else
		... //not licensed
}
//<

# Example for Samsung Apps
import com.pozirk.license.android.LicenseChecker;
import com.pozirk.license.android.LicenseCheckerEvent;

//> initialization
try
{
	_checker = new LicenseChecker();
	_checker.addEventListener(LicenseCheckerEvent.LICENSED, onLicensed);
	_checker.addEventListener(LicenseCheckerEvent.NOT_LICENSED, onNotLicensed);
}
catch(err:Error)
{
	...
}
//<

//checking license, pass empty string, there is no key for samsung
_checker.check("");

protected function onLicensed(event:LicenseCheckerEvent):void
{
	... //everything's ok
}

protected function onNotLicensed(event:LicenseCheckerEvent):void
{
	... //not licensed
}
