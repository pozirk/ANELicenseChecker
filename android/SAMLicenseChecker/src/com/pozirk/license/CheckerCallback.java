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
import com.samsung.zirconia.LicenseCheckListener;

public class CheckerCallback implements LicenseCheckListener
{
	private static final String LICENSED = "LICENSED"; 
	private static final String NOT_LICENSED = "NOT_LICENSED";
	
	private FREContext _ctx;
	
	@Override
	public void licenseCheckedAsValid()
	{
		_ctx.dispatchStatusEventAsync(LICENSED, "valid");
	}
	
	@Override
	public void licenseCheckedAsInvalid()
	{
		_ctx.dispatchStatusEventAsync(NOT_LICENSED, "invalid");
	}
	
	public CheckerCallback(FREContext ctx)
	{
		_ctx = ctx;
	}
}
