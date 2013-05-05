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

package com.pozirk.license.android
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.system.Capabilities;

	public class LicenseChecker extends EventDispatcher
	{
		protected var _ctx:ExtensionContext;
		
		public function LicenseChecker()
		{
			_ctx = ExtensionContext.createExtensionContext("com.pozirk.LicenseChecker", null);
			if(_ctx != null)
				_ctx.addEventListener(StatusEvent.STATUS, onStatus);
			else
				trace('_ctx is null.');
		}
		
		/**
		 * Check license
		 * @param	base64Key license key for you app
		 */
		public function check(base64Key:String):void
		{
			_ctx.call("check", base64Key);
		}
		
		protected function onStatus(event:StatusEvent):void
		{
			var e:LicenseCheckerEvent = null;
			//trace(event.code+event.level);
			switch(event.code)
			{
				case "LICENSED":
				{
					e = new LicenseCheckerEvent(LicenseCheckerEvent.LICENSED, event.level);
					break;
				}
				
				case "NOT_LICENSED":
				{
					e = new LicenseCheckerEvent(LicenseCheckerEvent.NOT_LICENSED, event.level);
					break;
				}
				
				case "APPLICATION_ERROR":
				{
					e = new LicenseCheckerEvent(LicenseCheckerEvent.APPLICATION_ERROR, event.level);
					break;
				}
			}
			
			if(e != null)
				this.dispatchEvent(e);
		}
		
		public function dispose():void
		{
			_ctx.dispose();
		}
	}
}