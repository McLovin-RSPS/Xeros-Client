package com.client.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;

import com.client.*;
import com.client.model.Npcs;
import com.client.utilities.FieldGenerator;
import com.client.utilities.FileOperations;
import com.client.utilities.TempWriter;
import net.runelite.api.HeadIcon;
import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSIterableNodeHashTable;
import net.runelite.rs.api.RSNPCComposition;


public final class NpcDefinition implements RSNPCComposition {

	public static NpcDefinition lookup(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].npcId == i)
				return cache[j];

		anInt56 = (anInt56 + 1) % 20;
		NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
		stream.currentPosition = streamIndices[i];
		entityDef.npcId = i;
		entityDef.readValues(stream);
		if (i == Npcs.BOB_BARTER_HERBS) {
			entityDef.actions = new String[] { "Talk-to", "Prices", "Decant", "Clean", null };
		}
		if (i == Npcs.ZAHUR)
			entityDef.actions[0] = "Trade";
		if (i == Npcs.JOSSIK) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 9460 || i == 1150 || i == 2912 || i == 2911 || i == 2910 || i == 6481
				|| i == 3500 || i == 9459 || i == 9457 || i == 9458) {
			// Setting combat to zero to npcs that can't be attacked
			entityDef.combatLevel = 0;
		}
		if (i == Npcs.PERDU) {
			entityDef.actions = new String[] { "Talk-to", null, "Reclaim-lost", null, null};
		}
		if (i == 8184) {
			entityDef.name = "Theatre Of Blood Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 7599) {
			entityDef.name = "Skotos Guide";
		}
		if (i == 1) {
			entityDef.name = "Nex";
			entityDef.models[0] = 75278;
			entityDef.actions = new String[]{null, "Attack", null, null, null};
			entityDef.combatLevel = 1001;
			entityDef.visible = true;
			entityDef.npcWidth = 10;
			entityDef.npcHeight = 50;
			entityDef.readyanim = -1;
			entityDef.walkanim = -1;
		}
		if (i == 4305) {
			entityDef.name = "Drunken cannoneer";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pickpocket";
		}
		if (i == 3247) {
			entityDef.name = "Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 6517) {
			entityDef.name = "Daily-reward wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "View rewards";
		}
		if (i == 3428 || i == 3429) {
			entityDef.name = "Elf warrior";
		}
		if (i == 5044) { // sanfew (decant)
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Decant-potions";
		}
		if (i == 8026) {
			entityDef.combatLevel = 392;
		}
		if (i == 7913) {
			entityDef.combatLevel = 0;
			entityDef.name = "Ironman shop keeper";
			entityDef.description = "A shop specifically for iron men.";

		}
		if (i == 8906) {
			entityDef.combatLevel = 0;
			entityDef.name = "Santa's little elf";
			entityDef.description = "A helper sent from santa himself.";
			entityDef.actions = new String[] { "Talk-To", null, "Christmas Shop", "Return-Items", null };
		}
		if (i == 954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Crystal Seed Trader";
			entityDef.description = "Use a seed on me to get a Crystal Bow.";

		}
		if (i == 6970) {
			entityDef.combatLevel = 0;
			entityDef.name = "Theif";
			entityDef.actions = new String[] { null, null, "Pickpocket",  null,  null };
		}
		if (i == 8761) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 9400) {
			entityDef.name = "Ted O'bombr";
		}
		if (i == 8026 || i == 8027 || i == 8028) {
			entityDef.size = 9;
		}
		if (i == 7954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Achievement Master";
			entityDef.actions = new String[] { "Trade", null, "Open Achievements", null, null, };

		}
		if (i == 5870) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 1013) {
			entityDef.combatLevel = 0;
			entityDef.name = "Gambler Shop";
			entityDef.description = "A shop specifically for gamblers.";

		}
		if (i == 5293) {
			entityDef.combatLevel = 0;
			entityDef.name = "Elven Keeper";
		}
		if(i==3218 || i ==3217){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==2897){
			entityDef.combatLevel = 0;
			entityDef.name = "Trading Post Manager";
			entityDef.actions = new String[] { "Open", null, "Collect", null, null };
		}
		if(i==1306){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Make-over", null, null, null, null };
		}
		if(i==3257){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1011){
			entityDef.combatLevel = 0;
			entityDef.name = "Item Gambler";
			entityDef.actions = new String[] { "Info", null, "Gamble", null, null };
		}
		if(i==3248){
			entityDef.combatLevel = 0;
			entityDef.name = Configuration.CLIENT_TITLE + " Wizard";
			entityDef.actions = new String[] { "Teleport", null, "Previous Location", null, null };
		}
		if(i==1520){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Small Net", null, "Harpoon", null, null };
		}
		if(i==8920){

			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==8921){
			entityDef.name = "Crystal Whirlwind";
		}
		if(i == 2662){
			entityDef.combatLevel = 0;
			entityDef.name = "Tournament Manager";
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if(i==603){
			entityDef.combatLevel = 0;
			entityDef.name = "Captain Kraken";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };

		}
		if(i==3894){
			entityDef.combatLevel = 0;
			entityDef.name = "Sigmund The Merchant";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}

		if (i==7413) {
			entityDef.name = "Max Dummy";
			entityDef.actions[0] = null;
		}
		if(i==1933){
			entityDef.combatLevel = 0;
			entityDef.name = "Mills";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==7769){
			entityDef.combatLevel = 0;
			entityDef.name = "Shop Keeper";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==6987){
			entityDef.combatLevel = 0;
			entityDef.name = "Man";
			entityDef.actions = new String[] { "Talk", null, "Pickpocket", null, null };
		}
		if(i==5730){
			entityDef.combatLevel = 0;
			entityDef.name = "Master Farmer";
			entityDef.actions = new String[] { "Pickpocket", null, "Trade", null, null };
		}
		if(i==1501){
			entityDef.combatLevel = 0;
			entityDef.name = "Hunter Store";
			entityDef.actions = new String[] { null, null, null, null, "Trade" };
		}
		if(i==2913){
			entityDef.combatLevel = 0;
			entityDef.name = "Fishing Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==5809){
			entityDef.combatLevel = 0;
			entityDef.name = "Crafting and Tanner";
			entityDef.actions = new String[] { "Tan", null, "Trade", null, null };

		}
		if(i==9168){
			entityDef.combatLevel = 0;
			entityDef.name = "Flex";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8208){
			entityDef.combatLevel = 0;
			entityDef.name = "Pet Collector";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==8202){
			entityDef.actions = new String[] { "Talk-to", "Pick-Up", null, null, null };
		}
		if(i==4921){
			entityDef.combatLevel = 0;
			entityDef.name = "Supplies";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 5314) {
			entityDef.combatLevel = 0;
			entityDef.name = "Mystical Wizard";
			entityDef.actions = new String[] { "Teleport", "Previous Location", null, null, null };
			entityDef.description = "This wizard has the power to teleport you to many locations.";
		}
		if (i == 8781) {
			entityDef.name = "@red@Queen Latsyrc";
			entityDef.combatLevel = 982;
			entityDef.drawmapdot = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 10520) {
			entityDef.name = "@red@AvatarOfCreation";
			entityDef.combatLevel = 1000;
			entityDef.drawmapdot = true;
			entityDef.readyanim = 8842;
			entityDef.walkanim = 8843;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 11704) {
			entityDef.name = "@red@Crondis";
			entityDef.combatLevel = 1000;
			entityDef.drawmapdot = true;
			entityDef.readyanim = 808;
			entityDef.walkanim = 8843;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 8026) {
			entityDef.name = "Vorkath";
			// entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.readyanim = 7946;
			entityDef.drawmapdot = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Poke", null, null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;//46191
		}
		if (i == 11654) {
			entityDef.name = "Apmeken";
			// entityDef.combatLevel = 732;
			entityDef.models = new int[] { 46191 };
			entityDef.readyanim = 808;
			entityDef.drawmapdot = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;//46191
		}
		if (i == 11655) {
			entityDef.name = "Pyramids Of Doom";
			entityDef.models = new int[] { 46210 };
			entityDef.readyanim = 9524;
			entityDef.walkanim = 9524;
			entityDef.drawmapdot = true;
			entityDef.originalColors = new int[]{8136, 8128};
			entityDef.newColors = new int[]{960, 960};
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if (i == 7852 || i == 7853 || i == 7884) {//Dawn
			entityDef.readyanim = 7775;
			entityDef.walkanim = 7775;
		}
		if (i == 5518) {
			entityDef.readyanim = 185;
		}
		if (i == 8019) {
			entityDef.readyanim = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 308) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
			entityDef.actions[3] = "Disable Interface";
			entityDef.actions[4] = "Skull";
		}
		if (i == 6088) {
			entityDef.readyanim = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Travel";
		}
		if (i == 1434 || i == 876 || i == 1612) {//gnome fix
			entityDef.readyanim = 185;
		}
		if (i == 7674 || i == 8009 || i == 388 || i == 8010) {

			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8492 || i == 8493 || i == 8494 || i == 8495) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8737 || i == 8738 || i == 8009 || i == 7674) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 326 || i == 327) {
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 85;
			entityDef.npcHeight = 85;
			entityDef.name = "Vote Pet";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i >= 7354 && i <=7367) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 5559 || i == 5560) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 2149 || i == 2150 || i == 2151 || i == 2148) {
			entityDef.name = "Trading Clerk";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Bank", null, "Trading Post", null, null };
		}
		if (i == 6473) { //terror dog
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGH
		}
		if (i == 3510) { //outlast shop
			entityDef.name = "Trader";
			entityDef.combatLevel = 0;
			entityDef.drawmapdot = true;
			entityDef.npcWidth = 150; //WIDTH
			entityDef.npcHeight = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if (i == 488) { //rain cloud
			entityDef.combatLevel = 0;
			entityDef.size = 1;
			entityDef.drawmapdot = true;
			entityDef.npcWidth = 150; //WIDTH
			entityDef.npcHeight = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 7668) { //voice of yama
			System.out.println((7668 >> 16));
			entityDef.name = "Kratos";
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1377) {
			entityDef.size = 3;
			entityDef.npcWidth = 300; //WIDTH
			entityDef.npcHeight = 300; // HEIGH
			entityDef.actions[0] = null;


		}
		if (i == 2105) {
			entityDef.size = 4;
			entityDef.npcWidth = 600; //WIDTH
			entityDef.npcHeight = 600; // HEIGH
		}
		if (i == 2107) {
			entityDef.size = 4;
			entityDef.npcWidth = 600; //WIDTH
			entityDef.npcHeight = 600; // HEIGH
		}
		if (i == 2850) {
			entityDef.name = "GIM Tracker";
			entityDef.actions = new String[] { "Open", null, null, null, null };

		}
		if (i == 6119) { //weird monster
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
		}
		if (i == 763) { //roc

			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };


		}
		if (i == 762) { //foe small bird
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 4987 || i == 6292 || i == 6354 ) { //chronzon
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 45; //WIDTH
			entityDef.npcHeight = 45; // HEIGH
		}
		if (i == 8709) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.name = "Corrupt Beast";
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 60; //WIDTH
			entityDef.npcHeight = 60; // HEIGH
			entityDef.size = 1;
		}
		if (i == 7025) { //guard dog
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}

		if (i == 6716) {//prayer
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;


		}
		if (i == 6723) {//healer
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;

		}
		if (i == 1088) {
			entityDef.name = "Seren";
			entityDef.models = new int[] { 38605 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8372;
			entityDef.walkanim = 8372;
			entityDef.models = new int[] { 38605 };

		}
		if (i == 1089) {
			entityDef.name = "Lil mimic";
			entityDef.models = new int[] { 37142 }; //37142
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 25; //WIDTH
			entityDef.npcHeight = 25; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8307;
			entityDef.walkanim = 8306;
			entityDef.models = new int[] { 37142 };
		}
		if (i == 4753) {
			entityDef.name = "Supplies";
			entityDef.models = new int[] { 60639 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 33; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 4488;
			entityDef.walkanim = 4488;
			entityDef.models = new int[] { 60639 };
		}
		if (i == 8688) {
			entityDef.name = "Supplies";
			entityDef.models = new int[] { 60377 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 33; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 9300;
			entityDef.walkanim = 9300;
			entityDef.models = new int[] { 60377 };
		}
		if (i == 1577) {
			entityDef.name = "Melee Shop";
			entityDef.models = new int[] { 61059 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 175; //WIDTH
			entityDef.npcHeight = 175; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 450;
			entityDef.walkanim = 450;
			entityDef.models = new int[] { 61059 };
		}
		if (i == 1576) {
			entityDef.name = "Ranging Store";
			entityDef.models = new int[] { 59861 }; //59861
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 33; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 59861 };
		}
		if (i == 8819) {
			entityDef.name = "Boss Point Store";
			entityDef.models = new int[] { 62733 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 33; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 62733 };
		}
		if (i == 6075) {
			entityDef.name = "tort";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 3952;
			entityDef.walkanim = 3953;
		}
		if (i == 6076) {
			entityDef.name = "war tort";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 75; //WIDTH
			entityDef.npcHeight = 75; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 3952;
			entityDef.walkanim = 3953;
		}
		if (i == 3604) {
			entityDef.name = "jubster";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 100; //WIDTH
			entityDef.npcHeight = 100; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 6803;
			entityDef.walkanim = 6804;
		}
		if (i == 8539) {
			entityDef.name = "arc_test";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8202;
			entityDef.walkanim = 8202;
		}
		if (i == 5802) {
			entityDef.name = "Autumn Elemental";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 5801;
			entityDef.walkanim = 5802;
		}
		if (i == 8556) {
			entityDef.name = "corkat";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 100; //WIDTH
			entityDef.npcHeight = 100; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8212;
			entityDef.walkanim = 8213;
		}
		if (i == 282) {
			entityDef.name = "Cormorant";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 75; // HEIGHT
			entityDef.combatLevel = 0;
			entityDef.readyanim = 6772;;
			entityDef.walkanim = 6774;
		}
		if (i == 9409) {
			entityDef.name = "daer krand";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 819;
		}
		if (i == 5079) {
			entityDef.name = "delrith";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 66;
			entityDef.walkanim = 63;
		}
		if (i == 5341) {
			entityDef.name = "Spirit of Zadimus";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 5530;
			entityDef.walkanim = 5531;
		}
		if (i == 8438) {
			entityDef.name = "don't know what";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8156;
			entityDef.walkanim = 8153;
		}
		if (i == 778) {
			entityDef.name = "Ethereal Lady";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = new int[]{ -31860, 410, -32236, -29529, 6573, -32500 };
			entityDef.newColors = new int[] { -16190, 29902, -15292, 231, -11165, -30132 };
			entityDef.combatLevel = 0;
			entityDef.readyanim = 813;
			entityDef.walkanim = 1205;
		}
		if (i == 4325) {
			entityDef.name = "Light Creature";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 125; //WIDTH
			entityDef.npcHeight = 125; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 2051;
			entityDef.walkanim = 2051;
		}
		if (i == 7118) {
			entityDef.name = "manaical monkey";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 200; //WIDTH
			entityDef.npcHeight = 200; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 1386;
			entityDef.walkanim = 1382;
		}
		if (i == 11412) {
			entityDef.name = "Xarpus";
			entityDef.models = new int[] { 62389 }; //35383
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 75; //WIDTH
			entityDef.npcHeight = 75; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8058;
			entityDef.walkanim = 8058;
			entityDef.models = new int[] { 62389 };
		}
		if (i == 11413) {
			entityDef.name = "Maiden";
			entityDef.models = new int[] { 35385 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 70; //WIDTH
			entityDef.npcHeight = 70; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8090;
			entityDef.walkanim = 8090;
			entityDef.models = new int[] { 35385 };
		}
		if (i == 11414) {
			entityDef.name = "Sotetseg";
			entityDef.models = new int[] { 35403 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Pick-Up", "Talk-To", null, null, null };
			entityDef.npcWidth = 57; //WIDTH
			entityDef.npcHeight = 57; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8137;
			entityDef.walkanim = 8136;
			entityDef.models = new int[] { 35403 };
		}
		if (i == 9120) {
			entityDef.name = "Donation Store";
			entityDef.models = new int[] { 62733 }; //63999
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 25; //WIDTH
			entityDef.npcHeight = 25; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 62733 }; //63999
		}
		if (i == 7041) {
			entityDef.name = "Ticket Exchange";
			entityDef.models = new int[] { 62905 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 62905 };
		}
		if (i == 9011) {
			entityDef.name = "Vote";
			entityDef.models = new int[] { 62901 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 50; //WIDTH
			entityDef.npcHeight = 50; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 62901 };
		}
		if (i == 7456) {
			entityDef.name = "Perdu";
			entityDef.models = new int[] { 62900 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 60; //WIDTH
			entityDef.npcHeight = 60; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 62900 };
		}
		if (i == 13) {
			entityDef.name = "Referal Tutor";
			entityDef.models = new int[] { 51285 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 33; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 51285 };

		}
		if (i == 308) {
			entityDef.name = "PKP Manager";
			entityDef.models = new int[] { 55404 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 35; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 55404 };
		}
		if (i == 555) {
			entityDef.name = "Sell Me Store";
			entityDef.models = new int[] { 52948 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 35; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 808;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 52948 };
		}
		if (i == 1578) {
			entityDef.name = "Magic Shop";
			entityDef.models = new int[] { 59988 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Trade", null, null };
			entityDef.npcWidth = 150; //WIDTH
			entityDef.npcHeight = 150; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 450;
			entityDef.walkanim = 808;
			entityDef.models = new int[] { 59988 };
		}
		if (i == 11500) {
			entityDef.name = "Raptor";
			entityDef.models = new int[] { 62231 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.npcWidth = 35; //WIDTH
			entityDef.npcHeight = 35; // HEIGHT
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 100;
			entityDef.readyanim = 808;
			entityDef.walkanim = 819;
			entityDef.models = new int[] { 62231 };
		}
		if (i == 2120) {
			entityDef.name = "Shadow Ranger";
			entityDef.models = new int[] { 29267 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.models = new int[] { 29267 };

		}
		if (i == 2121) {
			entityDef.name = "Shadow Wizard";
			entityDef.models = new int[] { 29268 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.models = new int[] { 29268 };
		}
		if (i == 2122) {
			entityDef.name = "Shadow Warrior";
			entityDef.models = new int[] { 29266 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.models = new int[] { 29266 };
		}

		if (i == 7216 || i == 6473) {//green monkey and green dog
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 6723 || i == 6716 || i == 8709) {
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 3291) {//postie pete
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 5738) {//imp
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 5240) {//toucan
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 834) {
			entityDef.name = "King penguin";
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1873) {//klik
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.readyanim = 3345;
			entityDef.walkanim = 3346;

		}
		//dark pets
		if (i == 2300) {
			entityDef.models = new int[1];
			entityDef.name = "Dark postie pete";
			entityDef.models = new int[] { 46600 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 3948;
			entityDef.walkanim = 3947;
		}
		if (i == 2301) {
			entityDef.name = "Dark imp";
			entityDef.models = new int[] { 46700 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 171;
			entityDef.walkanim = 168;
		}
		if (i == 2302) {
			entityDef.name = "Dark toucan";
			entityDef.models = new int[] { 46800, 46801 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 6772;
			entityDef.walkanim = 6774;
		}
		if (i == 2303) {
			entityDef.name = "Dark king penguin";
			entityDef.models = new int[] { 46200 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 5668;
			entityDef.walkanim = 5666;
		}
		if (i == 2304) {
			entityDef.name = "Dark k'klik";
			entityDef.models = new int[] { 46300, 46301, 46302 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 3346;
			entityDef.walkanim = -1;
		}
		if (i == 2305) {
			entityDef.name = "Dark shadow warrior";
			entityDef.models = new int[] { 46100 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2306) {
			entityDef.name = "Dark shadow archer";
			entityDef.models = new int[] { 56800 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2307) {
			entityDef.name = "Dark shadow wizard";
			entityDef.models = new int[] { 45900 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", "Examine", "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8526;
			entityDef.walkanim = 8527;
			entityDef.npcWidth = 85; //WIDTH
			entityDef.npcHeight = 85; // HEIGH
		}
		if (i == 2308) {
			entityDef.name = "Dark healer death spawn";
			entityDef.models = new int[] { 46500, 46501, 46502, 46503, 46504, 46505, 46506,};
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.readyanim = 1539;
			entityDef.walkanim = 1539;
		}
		if (i == 2309) {
			entityDef.name = "Dark holy death spawn";
			entityDef.models = new int[] { 46406, 46405, 46404, 46403, 46402, 46401, 46400 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.readyanim = 1539;
			entityDef.walkanim = 1539;
		}
		if (i == 2310) {
			entityDef.name = "Dark seren";
			entityDef.models = new int[] { 46900 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.readyanim = 8372;
			entityDef.walkanim = 8372;
			entityDef.npcWidth = 65; //WIDTH
			entityDef.npcHeight = 65; // HEIGH
		}
		if (i == 2311) {
			entityDef.name = "Dark corrupt beast";
			entityDef.models = new int[] { 45710 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 60; //WIDTH
			entityDef.npcHeight = 60; // HEIGH
			entityDef.size = 1;
			entityDef.readyanim = 5616;
			entityDef.walkanim = 5615;
		}
		if (i == 2312) {
			entityDef.name = "Dark roc";
			entityDef.models = new int[] { 45600, 45601 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.readyanim = 5021;
			entityDef.walkanim = 5022;
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 30; //WIDTH
			entityDef.npcHeight = 30; // HEIGH
		}
		if (i == 2313) {
			entityDef.name = "Dark kratos";
			entityDef.models = new int[] { 45500, 45501, 45502 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.readyanim = 7017;
			entityDef.walkanim = 7016;
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.npcWidth = 90; //WIDTH
			entityDef.npcHeight = 90; // HEIGH
		}
		if (i == 8027) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.readyanim = 7950;
			entityDef.drawmapdot = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, null, null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;
		}
		if (i == 8028) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.readyanim = 7948;
			entityDef.drawmapdot = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.npcWidth = 100;
			entityDef.npcHeight = 100;
		}
		if(i==7144){
			entityDef.headicon_prayer = 0;
		}
		if(i==963){
			entityDef.headicon_prayer = 6;
		}
		if(i==7145){
			entityDef.headicon_prayer = 1;
		}
		if(i==7146){
			entityDef.headicon_prayer = 2;
		}
		if (entityDef.name != null && entityDef.name.toLowerCase().contains("chinchompa") && !entityDef.name.toLowerCase().contains("baby")) {
			entityDef.actions = new String[5];
		}
		return entityDef;
	}
	public static int totalAmount;

	public static void dump() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./npc_defs.txt"))) {
			for (int i = 0; i < 70_000; i++) {
				try {
					NpcDefinition def = NpcDefinition.lookup(i);
					if (def != null) {
						writer.write("Npc=" + i);
						writer.newLine();
						writer.write("Stand animation=" + def.readyanim);
						writer.newLine();
						writer.write("Walk animation=" + def.walkanim);
						writer.newLine();
						writer.newLine();
					}
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void unpackConfig(FileArchive streamLoader) {
		stream = new Buffer(streamLoader.readFile("npc.dat"));
		Buffer stream = new Buffer(streamLoader.readFile("npc.idx"));
		totalAmount = stream.readUShort();
		streamIndices = new int[totalAmount];
		int i = 2;
		for (int j = 0; j < totalAmount; j++) {
			streamIndices[j] = i;
			i += stream.readUShort();
		}

		cache = new NpcDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NpcDefinition();
		for (int index = 0; index < totalAmount; index++) {
			NpcDefinition ed = lookup(index);
			if (ed == null)
				continue;
			if (ed.name == null)
				continue;
		}
		if (Configuration.dumpDataLists) {
			NpcDefinitionDumper.dump();

			TempWriter writer2 = new TempWriter("npc_fields");
			FieldGenerator generator = new FieldGenerator(writer2::writeLine);
			IntStream.range(0, 100_000).forEach(id -> {
				try {
					NpcDefinition definition = NpcDefinition.lookup(id);
					generator.add(definition.name, id);
				} catch (Exception e) {
				}
			});
			writer2.close();
		}
	}

	/*
	 * public void readValues(Stream stream) { do { int i =
	 * stream.readUnsignedByte(); if (i == 0) return; if (i == 1) { int j =
	 * stream.readUnsignedByte(); models = new int[j]; for (int j1 = 0; j1 < j;
	 * j1++) models[j1] = stream.readUnsignedWord();
	 *
	 * } else if (i == 2) name = stream.readString(); else if (i == 3) description =
	 * stream.readString(); else if (i == 12) squareLength =
	 * stream.readSignedByte(); else if (i == 13) standingAnimation =
	 * stream.readUnsignedWord(); else if (i == 14) walkingAnimation =
	 * stream.readUnsignedWord(); else if (i == 17) { walkingAnimation =
	 * stream.readUnsignedWord(); anInt58 = stream.readUnsignedWord(); anInt83 =
	 * stream.readUnsignedWord(); anInt55 = stream.readUnsignedWord(); if (anInt58
	 * == 65535) { anInt58 = -1; } if (anInt83 == 65535) { anInt83 = -1; } if
	 * (anInt55 == 65535) { anInt55 = -1; } } else if (i >= 30 && i < 40) { if
	 * (actions == null) actions = new String[5]; actions[i - 30] =
	 * stream.readString(); if (actions[i - 30].equalsIgnoreCase("hidden"))
	 * actions[i - 30] = null; } else if (i == 40) { int k =
	 * stream.readUnsignedByte(); originalColors = new int[k]; newColors = new
	 * int[k]; for (int k1 = 0; k1 < k; k1++) { originalColors[k1] =
	 * stream.readUnsignedWord(); newColors[k1] = stream.readUnsignedWord(); }
	 *
	 * } else if (i == 60) { int l = stream.readUnsignedByte(); dialogueModels = new
	 * int[l]; for (int l1 = 0; l1 < l; l1++) dialogueModels[l1] =
	 * stream.readUnsignedWord();
	 *
	 * } else if (i == 90) stream.readUnsignedWord(); else if (i == 91)
	 * stream.readUnsignedWord(); else if (i == 92) stream.readUnsignedWord(); else
	 * if (i == 93) minimapDot = false; else if (i == 95) combatLevel =
	 * stream.readUnsignedWord(); else if (i == 97) npcHeight =
	 * stream.readUnsignedWord(); else if (i == 98) npcWidth =
	 * stream.readUnsignedWord(); else if (i == 99) aBoolean93 = true; else if (i ==
	 * 100) npcWidth = stream.readSignedByte(); else if (i == 101) npcHeight
	 * =
	 * stream.readSignedByte() * 5; else if (i == 102) anInt75 =
	 * stream.readUnsignedByte(); else if (i == 103) getDegreesToTurn =
	 * stream.readUnsignedByte(); else if (i == 106) { anInt57 =
	 * stream.readUnsignedWord(); if (anInt57 == 65535) anInt57 = -1; anInt59 =
	 * stream.readUnsignedWord(); if (anInt59 == 65535) anInt59 = -1; int i1 =
	 * stream.readUnsignedByte(); childrenIDs = new int[i1 + 1]; for (int i2 = 0; i2
	 * <= i1; i2++) { childrenIDs[i2] = stream.readUnsignedWord(); if
	 * (childrenIDs[i2] == 65535) childrenIDs[i2] = -1; }
	 *
	 * } else if (i == 107) aBoolean84 = false; } while (true); }
	 */

	public int category;

	private void readValues(Buffer buffer) {
		while (true) {
			int opcode = buffer.get_unsignedbyte();
			if (opcode == 0)
				return;
			if (opcode == 1) {
				int j = buffer.get_unsignedbyte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = buffer.readUShort();

			} else if (opcode == 2)
				name = buffer.readJagexString();
			else if (opcode == 12)
				size = buffer.readSignedByte();
			else if (opcode == 13)
				readyanim = buffer.readUShort();
			else if (opcode == 14)
				walkanim = buffer.readUShort();
			else if (opcode == 15)
				readyanim_l = buffer.readUShort();
			else if (opcode == 16)
				readyanim_r = buffer.readUShort();
			else if (opcode == 17) {
				walkanim = buffer.readUShort();
				walkanim_b = buffer.readUShort();
				walkanim_l = buffer.readUShort();
				walkanim_r = buffer.readUShort();
				if (walkanim_b == 65535) {
					walkanim_b = -1;
				}
				if (walkanim_l == 65535) {
					walkanim_l = -1;
				}
				if (walkanim_r == 65535) {
					walkanim_r = -1;
				}
			} else if (opcode == 18) {
				category = buffer.readUShort();
			} else if (opcode >= 30 && opcode < 35) {
				if (actions == null)
					actions = new String[10];
				actions[opcode - 30] = buffer.readString();
				if (actions[opcode - 30].equalsIgnoreCase("hidden"))
					actions[opcode - 30] = null;
			} else if (opcode == 40) {
				int k = buffer.get_unsignedbyte();
				originalColors = new int[k];
				newColors = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalColors[k1] = buffer.readUShort();
					newColors[k1] = buffer.readUShort();
				}
			} else if (opcode == 41) {
				int k = buffer.get_unsignedbyte();
				originalTextures = new short[k];
				newTextures = new short[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalTextures[k1] = (short) buffer.readUShort();
					newTextures[k1] = (short) buffer.readUShort();
				}

			} else if (opcode == 60) {
				int l = buffer.get_unsignedbyte();
				chatheadModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					chatheadModels[l1] = buffer.readUShort();

			} else if (opcode == 93)
				drawmapdot = false;
			else if (opcode == 95)
				combatLevel = buffer.readUShort();
			else if (opcode == 97)
				npcHeight = buffer.readUShort();
			else if (opcode == 98)
				npcWidth = buffer.readUShort();
			else if (opcode == 99)
				visible = true;
			else if (opcode == 100)
				ambient = buffer.readSignedByte();
			else if (opcode == 101)
				contrast = buffer.readSignedByte();
			else if (opcode == 102)
				headicon_prayer = buffer.readUShort();
			else if (opcode == 103)
				turnspeed = buffer.readUShort();
			else if (opcode == 106 || opcode == 118) {
				multivarbit = buffer.readUShort();
				if (multivarbit == 65535)
					multivarbit = -1;
				multivarp = buffer.readUShort();
				if (multivarp == 65535)
					multivarp = -1;
				int var3 = -1;
				if (opcode == 118)
					var3 = buffer.readUShort();
				int i1 = buffer.get_unsignedbyte();
				multi = new int[i1 + 2];
				for (int i2 = 0; i2 <= i1; i2++) {
					multi[i2] = buffer.readUShort();
					if (multi[i2] == 65535)
						multi[i2] = -1;
				}
				multi[i1 + 1] = var3;
			} else if (opcode == 107) {
				active = false;
			} else if (opcode == 109) {
				this.smoothwalk = false;
			} else if (opcode == 111) {
				this.is_follower = true;
			} else if (opcode == 114) {
				this.runanim = buffer.get_unsignedshort();
			} else if (opcode == 115) {
				this.runanim = buffer.get_unsignedshort();
				this.runanim_b = buffer.get_unsignedshort();
				this.runanim_l = buffer.get_unsignedshort();
				this.runanim_r = buffer.get_unsignedshort();
			} else if (opcode == 116) {
				this.crawlanim = buffer.get_unsignedshort();
			} else if (opcode == 117) {
				this.crawlanim = buffer.get_unsignedshort();
				this.crawlanim_b = buffer.get_unsignedshort();
				this.crawlanim_l = buffer.get_unsignedshort();
				this.crawlanim_r = buffer.get_unsignedshort();
			} else if (opcode == 249) {
				int length = buffer.get_unsignedbyte();

				params = new HashMap<>(length);

				for (int i = 0; i < length; i++) {
					boolean isString = buffer.get_unsignedbyte() == 1;
					int key = buffer.read24Int();
					Object value;

					if (isString) {
						value = buffer.readString();
					} else {
						value = buffer.readInt();
					}

					params.put(key, value);
				}
			}
		}
	}

	public Model method160() {
		if (multi != null) {
			NpcDefinition entityDef = get_multi_npctype();
			if (entityDef == null)
				return null;
			else
				return entityDef.method160();
		}
		if (chatheadModels == null) {
			return null;
		}
		boolean flag1 = false;
		for (int i = 0; i < chatheadModels.length; i++)
			if (!Model.isCached(chatheadModels[i]))
				flag1 = true;

		if (flag1)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[chatheadModels.length];
		for (int j = 0; j < chatheadModels.length; j++)
			aclass30_sub2_sub4_sub6s[j] = Model.getModel(chatheadModels[j]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

		if (originalColors != null)
			for (int k = 0; k < originalColors.length; k++)
				model.recolor(originalColors[k], newColors[k]);


		if (originalTextures != null)
			for (int k = 0; k < originalTextures.length; k++)
				model.retexture(originalTextures[k], newTextures[k]);

		return model;
	}

	public NpcDefinition get_multi_npctype() {
		int j = -1;
		if (multivarbit != -1 && multivarbit <= 2113) {
			VarBit varBit = VarBit.cache[multivarbit];
			int k = varBit.setting;
			int l = varBit.start;
			int i1 = varBit.end;
			int j1 = Client.BIT_MASKS[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		} else if (multivarp != -1)
			j = clientInstance.variousSettings[multivarp];
		int var3;
		if (j >= 0 && j < multi.length)
			var3 = multi[j];
		else
			var3 = multi[multi.length - 1];
		return var3 == -1 ? null : lookup(var3);
	}

	public Model get_animated_entity_model(int primary_index, AnimationDefinition primary_seq, int[] ai, int secondary_index, AnimationDefinition secondary_seq) {
		if (multi != null) {
			NpcDefinition entityDef = get_multi_npctype();
			if (entityDef == null)
				return null;
			else
				return entityDef.get_animated_entity_model(primary_index, primary_seq, ai, secondary_index, secondary_seq);
		}
		Model model = (Model) mruNodes.get(npcId);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < models.length; i1++)
				if (!Model.isCached(models[i1]))
					flag = true;

			if (flag)
				return null;
			Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				aclass30_sub2_sub4_sub6s[j1] = Model.getModel(models[j1]);

			if (aclass30_sub2_sub4_sub6s.length == 1)
				model = aclass30_sub2_sub4_sub6s[0];
			else
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			if (originalColors != null) {
				for (int k1 = 0; k1 < originalColors.length; k1++)
					model.recolor(originalColors[k1], newColors[k1]);

			}
			if (originalTextures != null) {
				for (int i1 = 0; i1 < originalTextures.length; i1++)
					model.retexture(originalTextures[i1], newTextures[i1]);
			}

			model.light(64 + ambient, 850 + contrast, -30, -50, -30, true);
			// model.method479(84 + npcWidth, 1000 + npcHeight
			//, -90, -580, -90, true);
			mruNodes.put(model, npcId);
		}

//		Model model_1 = Model.emptyModel;
//		model_1.replaceModel(model, AnimFrame.noAnimationInProgress(primary_index) & AnimFrame.noAnimationInProgress(secondary_index));
//		if (primary_index != -1 && secondary_index != -1) {
//			model_1.animate_dual_either(primary_seq, primary_index, secondary_seq, secondary_index);
//		} else if (primary_index != -1) {
//			model_1.animate_either(primary_seq, primary_index);
//		}
		Model model_1;
		if (primary_seq != null && secondary_seq != null) {
			model_1 = primary_seq.animate_multiple(model, primary_index, secondary_seq, secondary_index);
		} else if (primary_seq != null) {
			model_1 = primary_seq.animate_either(model, primary_index);
		} else if (secondary_seq != null) {
			model_1 = secondary_seq.animate_either(model, secondary_index);
		} else {
			model_1 = model.bake_shared_animation_model(true);
		}
		if (npcHeight != 128 || npcWidth != 128)
			model_1.scale(npcHeight, npcHeight, npcWidth);
		model_1.calculateBoundsCylinder();
		model_1.face_label_groups = null;
		model_1.vertex_label_groups = null;
		if (size == 1)
			model_1.singleTile = true;
		return model_1;
	}

	private NpcDefinition() {
		walkanim = -1;
		walkanim_r = -1;
		multivarbit = -1;
		walkanim_b = -1;
		multivarp = -1;
		combatLevel = -1;
		anInt64 = 1834;
		walkanim = -1;
		size = 1;
		headicon_prayer = -1;
		readyanim = -1;
		npcId = -1L;
		turnspeed = 32;
		walkanim_l = -1;
		active = true;
		npcWidth = 128;
		drawmapdot = true;
		npcHeight = 128;
		visible = false;
	}

	@Override
	public String toString() {
		return "NpcDefinition{" +
				"npcId=" + npcId +
				", combatLevel=" + combatLevel +
				", name='" + name + '\'' +
				", actions=" + Arrays.toString(actions) +
				", walkingAnimation=" + walkanim +
				", size=" + size +
				", standingAnimation=" + readyanim +
				", childrenIDs=" + Arrays.toString(multi) +
				", models=" + Arrays.toString(models) +
				'}';
	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void dumpList() {
		try {
			File file = new File("./temp/npc_list.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = lookup(i);
					if (definition != null) {
						writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
								+ definition.readyanim + "\t" + definition.walkanim + "\t");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dumpSizes() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = lookup(i);
					if (definition != null) {
						writer.write(i + "	" + definition.size);
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap<Integer, Object> params;
	public boolean smoothwalk = true;
	public boolean is_follower = false;
	public int runanim_r = -1;
	public int readyanim_r = -1;
	public int readyanim_l = -1;
	public int walkanim_b = -1;

	public int walkanim_r = -1;
	public int runanim = -1;
	public int crawlanim = -1;
	public int runanim_l = -1;
	public int crawlanim_b = -1;
	public int runanim_b = -1;
	public int combatlevel = -1;
	public int crawlanim_r = -1;
	public int crawlanim_l = -1;


	public static int anInt56;
	public int multivarbit;

	public int multivarp;
	public static Buffer stream;
	public int combatLevel;
	public final int anInt64;
	public String name;
	public String actions[];
	public int walkanim;
	public byte size;
	public int[] newColors;
	public static int[] streamIndices;
	public int[] chatheadModels;
	public int headicon_prayer;
	public int[] originalColors;
	public short[] originalTextures, newTextures;
	public int readyanim;
	public long npcId;
	public int turnspeed;
	public static NpcDefinition[] cache;
	public static Client clientInstance;
	public int walkanim_l;
	public boolean active;
	public int ambient;
	public int npcWidth;
	public boolean drawmapdot;
	public int multi[];
	public String description;
	public int npcHeight;
	public int contrast;
	public boolean visible;
	public int[] models;
	public static ReferenceCache mruNodes = new ReferenceCache(70);
	public int[] anIntArray76;

	@Override
	public HeadIcon getOverheadIcon() {
		return null;
	}

	@Override
	public int getIntValue(int paramID) {
		return 0;
	}

	@Override
	public void setValue(int paramID, int value) {

	}

	@Override
	public String getStringValue(int paramID) {
		return null;
	}

	@Override
	public void setValue(int paramID, String value) {

	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int[] getModels() {
		return new int[0];
	}

	@Override
	public String[] getActions() {
		return new String[0];
	}

	@Override
	public boolean isClickable() {
		return false;
	}

	@Override
	public boolean isFollower() {
		return false;
	}

	@Override
	public boolean isInteractible() {
		return false;
	}

	@Override
	public boolean isMinimapVisible() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public int getCombatLevel() {
		return 0;
	}

	@Override
	public int[] getConfigs() {
		return new int[0];
	}

	@Override
	public RSNPCComposition transform() {
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int getRsOverheadIcon() {
		return 0;
	}

	@Override
	public RSIterableNodeHashTable getParams() {
		return null;
	}

	@Override
	public void setParams(IterableHashTable params) {

	}

	@Override
	public void setParams(RSIterableNodeHashTable params) {

	}
}