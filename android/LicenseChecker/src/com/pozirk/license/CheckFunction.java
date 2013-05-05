/* Copyright (c) 2013 Pozirk Games
 * http://www.pozirk.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pozirk.license;

import android.app.Activity;
import android.provider.Settings.Secure;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.ServerManagedPolicy;

public class CheckFunction implements FREFunction
{	
	private static final byte[] SUGAR = new byte[]
	{
	    -34, 56, 38, -102, -115, -76, 45, -89, 32, 68, -123, -87, 34, -6, -54, -23, -62, 113, -83, 98
	};

	private CheckerCallback _licenseCheckerCallback;
	private LicenseChecker _checker;
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		ExtensionContext ctx = (ExtensionContext)arg0;
		Activity act = ctx.getActivity();
		
		try
		{
			FREObject input = arg1[0]; 
			String base64Key = input.getAsString();
		
			String deviceId = Secure.getString(act.getContentResolver(), Secure.ANDROID_ID);

	        // Library calls this when it's done.
	        _licenseCheckerCallback = new CheckerCallback(ctx);
	        // Construct the LicenseChecker with a policy.
	        _checker = new LicenseChecker(
	            act, new ServerManagedPolicy(act,
	                new AESObfuscator(SUGAR, act.getPackageName(), deviceId)),
	                base64Key);
	        
			_checker.checkAccess(_licenseCheckerCallback);
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		} 
		
		return null;
	}
}