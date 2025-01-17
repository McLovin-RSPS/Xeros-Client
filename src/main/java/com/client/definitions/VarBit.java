package com.client.definitions;

import com.client.Buffer;
import com.client.FileArchive;

public final class VarBit {

	public static void unpackConfig(FileArchive streamLoader) {
		Buffer stream = new Buffer(streamLoader.readFile("varbit.dat"));
		int cacheSize = stream.readUShort();
		if (cache == null)
			cache = new VarBit[cacheSize];
		for (int j = 0; j < cacheSize; j++) {
			if (cache[j] == null)
				cache[j] = new VarBit();
			cache[j].decode(stream);
		}

		if (stream.currentPosition != stream.payload.length)
			System.out.println("varbit load mismatch");
	}

	private void decode(Buffer buffer) {
		int opcode = buffer.get_unsignedbyte();

		if (opcode == 0) {
			return;
		} else if (opcode == 1) {
			setting = buffer.readUShort();
			start = buffer.get_unsignedbyte();
			end = buffer.get_unsignedbyte();
		} else {
			System.out.println("Invalid varbit opcode: " + opcode);
		}
	}


	private VarBit() {
		
	}

	public static VarBit cache[];
	public int setting;
	public int start;
	public int end;
	
}
