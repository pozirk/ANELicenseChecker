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
	import flash.events.Event;
	
	public class LicenseCheckerEvent extends Event
	{
		public static const LICENSED:String = "LICENSED"; 
		public static const NOT_LICENSED:String = "NOT_LICENSED";
		public static const APPLICATION_ERROR:String = "APPLICATION_ERROR";
		
		public static const OK:int = 0x0100;
		public static const FAIL:int = 0x0231;
		public static const RETRY:int = 0x0123;
		
		public var data:String;
		
		public function LicenseCheckerEvent(type:String, data:String = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.data = data;
			super(type, bubbles, cancelable);
		}
	}
}