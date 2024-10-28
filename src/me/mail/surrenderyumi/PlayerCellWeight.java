package me.mail.surrenderyumi;

import java.util.Arrays;

public class PlayerCellWeight {

	private static int coefficient = 4;
	private int playertype; // 0 toobusy, 1 smallbusy, 2 notbusy, 3 pve, 4 pvp, 5 pvevp, 6 solo, 7 group,  guild, 9 researcher, 10 fighter
	
	private float[] size = new float[] {0.5f,0.5f,0.5f,0.5f};
	private float[] time = new float[] {0.5f,0.5f};
	private float[] valuable = new float[] {0.5f,0.5f};
	private float[] typeway = new float[] {0.5f,0.5f,0.5f};
	private float[] difficult = new float[] {0.5f,0.5f};
	private float[] menhunted = new float[] {0.5f,0.5f,0.5f,0.5f};
	
	private float requirement = 0.55f;
	
	public PlayerCellWeight(int playertype) {
		this.playertype = playertype;
	}
	
	public int getPlayertype() {
		return playertype;
	}
	
	public float getsize(int number) {
		return size[number];
	}
	public int getPreferredSize() {
		return findPreferrence(size);
	}
	public float getTime(int number) {
		return time[number];
	}
	public int getPreferredTime() {
		return findPreferrence(time);
	}
	public float getValuable(int number) {
		return valuable[number];
	}
	public int getPreferredValuable() {
		return findPreferrence(valuable);
	}
	public float getTypeway(int number) {
		return typeway[number];
	}
	public int getPreferredTypeway() {
		return findPreferrence(typeway);
	}
	public float getDifficult(int number) {
		return difficult[number];
	}
	public int getPreferredDifficult() {
		return findPreferrence(difficult);
	}
	public float getMenhunted(int number) {
		return menhunted[number];
	}
	public int getPreferredMenhunted() {
		return findPreferrence(menhunted);
	}
	public void setSize(float state, int step) {
		if(state > size[step]) {
			size[step]+=state/coefficient;
		} else if(state < size[step]) {
			size[step]-=state/coefficient;
		}
	}
	public void setTime(float state, int step) {
		if(state > time[step]) {
			time[step]+=state/coefficient;
		} else if(state < time[step]) {
			time[step]-=state/coefficient;
		}
	}
	public void setValuable(float state, int step) {
		if(state > valuable[step]) {
			valuable[step]+=state/coefficient;
		} else if(state < valuable[step]) {
			valuable[step]-=state/coefficient;
		}
	}
	public void setTypeway(float state, int step) {
		if(state > typeway[step]) {
			typeway[step]+=state/coefficient;
		} else if(state < typeway[step]) {
			typeway[step]-=state/coefficient;
		}
	}
	public void setDifficult(float state, int step) {
		if(state > difficult[step]) {
			difficult[step]+=state/coefficient;
		} else if(state < difficult[step]) {
			difficult[step]-=state/coefficient;
		}
	}
	public void setMenhunted(float state, int step) {
		if(state > menhunted[step]) {
			menhunted[step]+=state/coefficient;
		} else if(state < menhunted[step]) {
			menhunted[step]-=state/coefficient;
		}
	}
	
	public float getRequirement() {
		return requirement;
	}
	
	public void setRequirement(int requirement) {
		this.requirement = requirement;
	}
	
	private int findPreferrence(float[] array) {
		int result = 0;
		float current = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i]>current) {
				current = array[i];
				result = i;
			}
		}
		return result;
	}
	
	public void showWeights() {
		System.out.println("size: " + Arrays.toString(size)
				+ "\n" + "time: " + Arrays.toString(time)
				+ "\n" + "valuable: " + Arrays.toString(valuable)
				+ "\n" + "typeway: " + Arrays.toString(typeway)
				+ "\n" + "difficult: " + Arrays.toString(difficult)
				+ "\n" + "menhunted: " + Arrays.toString(menhunted));
		System.out.println("Event requirements are: " + requirement);
	}
}
