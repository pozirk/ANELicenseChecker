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

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.samsung.zirconia.Zirconia;

public class CheckFunction implements FREFunction
{
	private CheckerCallback _licenseCheckerCallback;
	private Zirconia _checker;
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		ExtensionContext ctx = (ExtensionContext)arg0;
		Activity act = ctx.getActivity();
		
		try
		{
	        // Library calls this when it's done.
	        _licenseCheckerCallback = new CheckerCallback(ctx);
	        // Construct the LicenseChecker with a policy.
	        _checker = new Zirconia(act);
	        _checker.setLicenseCheckListener(_licenseCheckerCallback);
	        
	        _checker.checkLicense(false, false);
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		} 
		
		return null;
	}
}