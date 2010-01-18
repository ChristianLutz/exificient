/*
 * Copyright (C) 2007-2010 Siemens AG
 *
 * This program and its interfaces are free software;
 * you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.siemens.ct.exi.datatype;

import java.io.IOException;

import com.siemens.ct.exi.io.channel.EncoderChannel;
import com.siemens.ct.exi.util.datatype.DatetimeType;
import com.siemens.ct.exi.util.datatype.XSDDatetime;

public class DatetimeTest extends AbstractTestCase {
	protected XSDDatetime datetime = XSDDatetime.newInstance();

	public DatetimeTest(String testName) {
		super(testName);
	}

	/*
	 * gYear
	 */
	public void testDatetimeGYear0() throws IOException {
		String s = "2007";
		DatetimeType type = DatetimeType.gYear;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(s.equals(getBitDecoder().decodeDateTimeValue(type).toString()));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(s.equals(getByteDecoder().decodeDateTimeValue(type).toString()));
	}

	public void testDatetimeGYear1() throws IOException {
		String s = "-0007";
		DatetimeType type = DatetimeType.gYear;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGYear2() throws IOException {
		String s = "2001Z";
		String sRes = "2001";
		DatetimeType type = DatetimeType.gYear;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
	}

	public void testDatetimeGYear3() throws IOException {
		String s = "2001+05:00";
		DatetimeType type = DatetimeType.gYear;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	/*
	 * gYearMonth
	 */
	public void testDatetimeGYearMonth0() throws IOException {
		String s = "1999-10";
		DatetimeType type = DatetimeType.gYearMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGYearMonth1() throws IOException {
		String s = "2007-10";
		DatetimeType type = DatetimeType.gYearMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGYearMonth2() throws IOException {
		String s = "1999-10-12:11";
		DatetimeType type = DatetimeType.gYearMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGYearMonth3() throws IOException {
		String s = "1809-10+00:33";
		DatetimeType type = DatetimeType.gYearMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	/*
	 * date
	 */
	public void testDatetimeDate0() throws IOException {
		String s = "2002-10-11+13:00";
		DatetimeType type = DatetimeType.date;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeDate1() throws IOException {
		String s = "0100-10-11-00:50";
		DatetimeType type = DatetimeType.date;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	/*
	 * dateTime
	 */
	public void testDatetimeDateTime0() throws IOException {
		String s = "0001-01-01T01:03:12";
		DatetimeType type = DatetimeType.dateTime;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeDateTime1() throws IOException {
		String s = "2005-01-01T00:00:00Z";
		String sRes = "2005-01-01T00:00:00";
		DatetimeType type = DatetimeType.dateTime;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
	}

	public void testDatetimeDateTime2() throws IOException {
		String s = "1979-01-01T00:00:00.0120";
		String sRes = "1979-01-01T00:00:00.012";
		DatetimeType type = DatetimeType.dateTime;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
	}

	public void testDatetimeDateTime3() throws IOException {
		String s = "0001-01-01T00:00:00.111+00:33";
		DatetimeType type = DatetimeType.dateTime;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	/*
	 * gMonth
	 */
	public void testDatetimeGMonth0() throws IOException {
		String s = "--12";
		DatetimeType type = DatetimeType.gMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGMonth1() throws IOException {
		String s = "--07Z";
		String sRes = "--07";
		DatetimeType type = DatetimeType.gMonth;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
	}

	/*
	 * gMonthDay
	 */
	public void testDatetimeGMonthDay0() throws IOException {
		String s = "--01-28";
		DatetimeType type = DatetimeType.gMonthDay;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeGMonthDay1() throws IOException {
		String s = "--10-17+00:00";
		String sRes = "--10-17";
		DatetimeType type = DatetimeType.gMonthDay;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), sRes));
	}

	/*
	 * gDay
	 */
	public void testDatetimeGDay0() throws IOException {
		String s = "---16";
		DatetimeType type = DatetimeType.gDay;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	/*
	 * time
	 */
	public void testDatetimeTime0() throws IOException {
		String s = "12:34:56";
		DatetimeType type = DatetimeType.time;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeTime1() throws IOException {
		String s = "12:34:56.135";
		DatetimeType type = DatetimeType.time;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeTime2() throws IOException {
		String s = "12:34:56.135-12:56";
		DatetimeType type = DatetimeType.time;
		boolean valid = datetime.parse(s, type);
		assertTrue(valid);

		// Bit
		EncoderChannel bitEC = getBitEncoder();
		bitEC.encodeDateTime(datetime);
		bitEC.flush();
		assertTrue(equals(getBitDecoder().decodeDateTimeValue(type).toCharacters(), s));
		// Byte
		getByteEncoder().encodeDateTime(datetime);
		assertTrue(equals(getByteDecoder().decodeDateTimeValue(type).toCharacters(), s));
	}

	public void testDatetimeFail1() throws IOException {
		String s = "12:34:XXX";
		DatetimeType type = DatetimeType.time;
		boolean valid = datetime.parse(s, type);
		assertFalse(valid);
	}

}