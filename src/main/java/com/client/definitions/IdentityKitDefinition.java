package com.client.definitions;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.client.Buffer;
import com.client.Model;
import com.client.StreamLoader;

public final class IdentityKitDefinition {

	public static void unpackConfig(StreamLoader streamLoader) {
		Buffer stream = new Buffer(streamLoader.getArchiveData("idk.dat"));
		length = stream.readUShort();
		if (cache == null)
			cache = new IdentityKitDefinition[length];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new IdentityKitDefinition();
			cache[j].readValues(stream);
			cache[j].colourToFind[0] = (short) 55232;
			cache[j].colourToReplace[0] = 6798;
		}
	}

	private void readValues(Buffer stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1)
				bodyPartId = stream.readUnsignedByte();
			else if (i == 2) {
				int j = stream.readUnsignedByte();
				modelIds = new int[j];
				for (int k = 0; k < j; k++)
					modelIds[k] = stream.readUShort();
			} else if (i == 3)
				nonSelectable = true;
			else if (i == 40) {
				int length = stream.readUnsignedByte();
				colourToFind = new short[length];
				colourToReplace = new short[length];
				for(int idx = 0;idx<length;idx++) {
					colourToFind[idx] = (short) stream.readUShort();
					colourToReplace[idx] = (short) stream.readUShort();
				}
			} else if (i == 41) {
				int length = stream.readUnsignedByte();
				textureToFind = new short[length];
				textureToReplace = new short[length];
				for(int idx = 0;idx<length;idx++) {
					textureToFind[idx] = (short) stream.readUShort();
					textureToReplace[idx] = (short) stream.readUShort();
				}
			} else if (i >= 60 && i < 70) {
				models[i - 60] = stream.readUShort();
				if(models[i - 60] == 65535)
					models[i - 60] = -1;
			}
			else
				System.out.println("Error unrecognised config code: " + i);
		} while (true);
	}

	public boolean method537() {
		if (modelIds == null)
			return true;
		boolean flag = true;
		for (int j = 0; j < modelIds.length; j++)
			if (!Model.method463(modelIds[j]))
				flag = false;

		return flag;
	}

	public Model method538() {
		if (modelIds == null)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[modelIds.length];
		for (int i = 0; i < modelIds.length; i++)
			aclass30_sub2_sub4_sub6s[i] = Model.method462(modelIds[i]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length,
					aclass30_sub2_sub4_sub6s);
		if(colourToFind != null) {
			for (int j = 0; j < colourToFind.length; j++) {
				model.recolor(colourToFind[j], colourToReplace[j]);
			}
		}
		if(textureToFind != null){
			for(int j = 0; j < textureToFind.length; j++){
				model.retexture(textureToFind[j], textureToReplace[j]);
			}
		}

		return model;
	}

	public boolean method539() {
		boolean flag1 = true;
		for (int i = 0; i < 5; i++)
			if (models[i] != -1 && !Model.method463(models[i]))
				flag1 = false;

		return flag1;
	}

	public Model method540() {
		Model aclass30_sub2_sub4_sub6s[] = new Model[5];
		int j = 0;
		for (int k = 0; k < 5; k++)
			if (models[k] != -1)
				aclass30_sub2_sub4_sub6s[j++] = Model
						.method462(models[k]);

		Model model = new Model(j, aclass30_sub2_sub4_sub6s);
		if(colourToFind != null) {
			for (int j3 = 0; j3 < colourToFind.length; j3++) {
				model.recolor(colourToFind[j3], colourToReplace[j3]);
			}
		}
		if(textureToFind != null){
			for(int j2 = 0; j2 < textureToFind.length; j2++){
				model.retexture(textureToFind[j2], textureToReplace[j2]);
			}
		}

		return model;
	}

	private IdentityKitDefinition() {
		bodyPartId = -1;
		nonSelectable = false;
		colourToFind = new short[6];
		colourToReplace = new short[6];
	}

	public static int length;
	public static IdentityKitDefinition cache[];
	public int bodyPartId;
	private int[] modelIds;
	private short[] colourToFind;
	private short[] colourToReplace;
	private short[] textureToFind;
	private short[] textureToReplace;
	private final int[] models = { -1, -1, -1, -1, -1 };
	public boolean nonSelectable;
}