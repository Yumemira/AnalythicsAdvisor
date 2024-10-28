package me.mail.surrenderyumi;


public class EventResult {
	private int size; // 0 small, 1 medium, 2 big, 3 global
	private int time; // 0 less 12 h, 1 more 12 h 
	private int valuable; // 0 less then 1 h per day, 1 more or free
	private int typeway; // 0 fight, 1 adventure, 2 research
	private int difficult; // 0 allallowed, 1 hard
	private int menhunted; // 0 sollo, 1 party, 2 raid, 3 guild
	
	private float toobusy; // 0 less then 1 h per day
	private float smallbusy; // 1 less then 5 h per day
	private float notbusy; // 2 more 5 h per day
	private float pve; // style type
	private float pvp; // style type
	private float pvevp; // style type
	private float sollo; // player type
	private float party; // player type
	private float guild; // player type
	private float researcher; // player type
	private float fighter; // player type

	
	
	public EventResult(int size, int time, int valuable, int typeway, int difficult, int menhunted,
			float toobusy, float smallbusy, float notbusy, float pve, float pvp, float pvevp,
			float sollo, float party, float guild, float researcher, float fighter) {
		this.size = size;
		this.time = time;
		this.valuable = valuable;
		this.typeway = typeway;
		this.difficult = difficult;
		this.menhunted = menhunted;
		
		this.toobusy = toobusy;
		this.smallbusy = smallbusy;
		this.notbusy = notbusy;
		this.pve = pve;
		this.pvp = pvp;
		this.pvevp = pvevp;
		this.sollo = sollo;
		this.party = party;
		this.guild = guild;
		this.researcher = researcher;
		this.fighter = fighter;
	}
	
	
	public int getSize() {
		return size;
	}
	public int getTime() {
		return time;
	}
	public int getValuable() {
		return valuable;
	}
	public int getTypeway() {
		return typeway;
	}
	public int getDifficult() {
		return difficult;
	}
	public int getMenhunted() {
		return menhunted;
	}
	public float getToobusy() {
		return toobusy;
	}
	public float getSmallbusy() {
		return smallbusy;
	}
	public float getNotbusy() {
		return notbusy;
	}
	public float getPve() {
		return pve;
	}
	public float getPvp() {
		return pvp;
	}
	public float getPvevp() {
		return pvevp;
	}
	public float getSollo() {
		return sollo;
	}
	public float getParty() {
		return party;
	}
	public float getGuild() {
		return guild;
	}
	public float getResearcher() {
		return researcher;
	}
	public float getFighter() {
		return fighter;
	}
	
	public void printEventMetadata() {
		String output = "";
		output +="\n" + " s: " + getSize() + " t: " + getTime() + " tw: " + getValuable() + " event: " + getTypeway()
		+ " d: " + getDifficult() + " m: " + getMenhunted() 
		+ "\n" +  " tb: " + getToobusy() + " sb: " + getSmallbusy()+ " nb: " + getNotbusy() 
		+ "\n" +  " pve: " + getPve() + " pvp: " + getPvp() + " pvevp: " + getPvevp()
		+ "\n" + " sollo: " + getSollo() + " party: " + getParty() + " guild: " + getGuild()
		+ "\n" + " researches: " + getResearcher() + " fighters: " + getFighter() + "\n";
		System.out.print(output);
	}
}
