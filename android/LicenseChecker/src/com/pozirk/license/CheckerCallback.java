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


import com.adobe.fre.FREContext;
import com.google.android.vending.licensing.LicenseCheckerCallback;

public class CheckerCallback implements LicenseCheckerCallback
{
	private static final String LICENSED = "LICENSED"; 
	private static final String NOT_LICENSED = "NOT_LICENSED";
	private static final String APPLICATION_ERROR = "APPLICATION_ERROR";
	
	private FREContext _ctx;
	

	public CheckerCallback(FREContext ctx)
	{
		_ctx = ctx;
	}


	public void allow(int policyReason)
	{
		_ctx.dispatchStatusEventAsync(LICENSED, String.valueOf(policyReason));
	}


	public void dontAllow(int policyReason)
	{
		_ctx.dispatchStatusEventAsync(NOT_LICENSED, String.valueOf(policyReason));
	}

	public void applicationError(int errorCode)
	{
		_ctx.dispatchStatusEventAsync(APPLICATION_ERROR, String.valueOf(errorCode));
	}
}
