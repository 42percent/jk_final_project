package bit.your.prj.dto;

import java.io.Serializable;

public class RecipeDto implements Serializable {

	private int seq;
	private String id;
	private String recipetitle;
	
	private String bestimg;
	private String newbestimg;
	
	private String recintroduce;
	private String reccategory;
	private String recperson;
	private String rectime;
	private String reclevel;
	private String ingredient;
	private int readcount;
	private int liked;
	
	private String reccontent;
	private String reccontent_b;
	private String reccontent_c;
	private String reccontent_d;
	private String reccontent_e;
	private String reccontent_f;
	
	private String recimg;
	private String newrecimg;
	private String recimg_b;
	private String newrecimg_b;
	private String recimg_c;
	private String newrecimg_c;
	private String recimg_d;
	private String newrecimg_d;
	private String recimg_e;
	private String newrecimg_e;
	private String recimg_f;
	private String newrecimg_f;
	private int del;
	
	public RecipeDto() {
	}


	


	public RecipeDto(int seq, String id, String recipetitle, String bestimg, String newbestimg, String recintroduce,
			String reccategory, String recperson, String rectime, String reclevel, String ingredient, int readcount,
			int liked, String reccontent, String reccontent_b, String reccontent_c, String reccontent_d,
			String reccontent_e, String reccontent_f, String recimg, String newrecimg, String recimg_b,
			String newrecimg_b, String recimg_c, String newrecimg_c, String recimg_d, String newrecimg_d,
			String recimg_e, String newrecimg_e, String recimg_f, String newrecimg_f, int del) {
		super();
		this.seq = seq;
		this.id = id;
		this.recipetitle = recipetitle;
		this.bestimg = bestimg;
		this.newbestimg = newbestimg;
		this.recintroduce = recintroduce;
		this.reccategory = reccategory;
		this.recperson = recperson;
		this.rectime = rectime;
		this.reclevel = reclevel;
		this.ingredient = ingredient;
		this.readcount = readcount;
		this.liked = liked;
		this.reccontent = reccontent;
		this.reccontent_b = reccontent_b;
		this.reccontent_c = reccontent_c;
		this.reccontent_d = reccontent_d;
		this.reccontent_e = reccontent_e;
		this.reccontent_f = reccontent_f;
		this.recimg = recimg;
		this.newrecimg = newrecimg;
		this.recimg_b = recimg_b;
		this.newrecimg_b = newrecimg_b;
		this.recimg_c = recimg_c;
		this.newrecimg_c = newrecimg_c;
		this.recimg_d = recimg_d;
		this.newrecimg_d = newrecimg_d;
		this.recimg_e = recimg_e;
		this.newrecimg_e = newrecimg_e;
		this.recimg_f = recimg_f;
		this.newrecimg_f = newrecimg_f;
		this.del = del;
	}





	public RecipeDto(String id, String recipetitle, String bestimg, String newbestimg, String recintroduce,
			String reccategory, String recperson, String rectime, String reclevel, String ingredient, String reccontent,
			String reccontent_b, String reccontent_c, String reccontent_d, String reccontent_e, String reccontent_f,
			String recimg, String newrecimg, String recimg_b, String newrecimg_b, String recimg_c, String newrecimg_c,
			String recimg_d, String newrecimg_d, String recimg_e, String newrecimg_e, String recimg_f,
			String newrecimg_f) {
		super();
		this.id = id;
		this.recipetitle = recipetitle;
		this.bestimg = bestimg;
		this.newbestimg = newbestimg;
		this.recintroduce = recintroduce;
		this.reccategory = reccategory;
		this.recperson = recperson;
		this.rectime = rectime;
		this.reclevel = reclevel;
		this.ingredient = ingredient;
		this.reccontent = reccontent;
		this.reccontent_b = reccontent_b;
		this.reccontent_c = reccontent_c;
		this.reccontent_d = reccontent_d;
		this.reccontent_e = reccontent_e;
		this.reccontent_f = reccontent_f;
		this.recimg = recimg;
		this.newrecimg = newrecimg;
		this.recimg_b = recimg_b;
		this.newrecimg_b = newrecimg_b;
		this.recimg_c = recimg_c;
		this.newrecimg_c = newrecimg_c;
		this.recimg_d = recimg_d;
		this.newrecimg_d = newrecimg_d;
		this.recimg_e = recimg_e;
		this.newrecimg_e = newrecimg_e;
		this.recimg_f = recimg_f;
		this.newrecimg_f = newrecimg_f;
	}


	public int getSeq() {
		return seq;
	}


	public String getId() {
		return id;
	}


	public String getRecipetitle() {
		return recipetitle;
	}


	public String getBestimg() {
		return bestimg;
	}


	public String getNewbestimg() {
		return newbestimg;
	}


	public String getRecintroduce() {
		return recintroduce;
	}


	public String getReccategory() {
		return reccategory;
	}


	public String getRecperson() {
		return recperson;
	}


	public String getRectime() {
		return rectime;
	}


	public String getReclevel() {
		return reclevel;
	}


	public String getIngredient() {
		return ingredient;
	}


	public int getReadcount() {
		return readcount;
	}


	public int getLiked() {
		return liked;
	}


	public String getReccontent() {
		return reccontent;
	}


	public String getReccontent_b() {
		return reccontent_b;
	}


	public String getReccontent_c() {
		return reccontent_c;
	}


	public String getReccontent_d() {
		return reccontent_d;
	}


	public String getReccontent_e() {
		return reccontent_e;
	}


	public String getReccontent_f() {
		return reccontent_f;
	}


	public String getRecimg() {
		return recimg;
	}


	public String getNewrecimg() {
		return newrecimg;
	}


	public String getRecimg_b() {
		return recimg_b;
	}


	public String getNewrecimg_b() {
		return newrecimg_b;
	}


	public String getRecimg_c() {
		return recimg_c;
	}


	public String getNewrecimg_c() {
		return newrecimg_c;
	}


	public String getRecimg_d() {
		return recimg_d;
	}


	public String getNewrecimg_d() {
		return newrecimg_d;
	}


	public String getRecimg_e() {
		return recimg_e;
	}


	public String getNewrecimg_e() {
		return newrecimg_e;
	}


	public String getRecimg_f() {
		return recimg_f;
	}


	public String getNewrecimg_f() {
		return newrecimg_f;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setRecipetitle(String recipetitle) {
		this.recipetitle = recipetitle;
	}


	public void setBestimg(String bestimg) {
		this.bestimg = bestimg;
	}


	public void setNewbestimg(String newbestimg) {
		this.newbestimg = newbestimg;
	}


	public void setRecintroduce(String recintroduce) {
		this.recintroduce = recintroduce;
	}


	public void setReccategory(String reccategory) {
		this.reccategory = reccategory;
	}


	public void setRecperson(String recperson) {
		this.recperson = recperson;
	}


	public void setRectime(String rectime) {
		this.rectime = rectime;
	}


	public void setReclevel(String reclevel) {
		this.reclevel = reclevel;
	}


	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public void setLiked(int liked) {
		this.liked = liked;
	}


	public void setReccontent(String reccontent) {
		this.reccontent = reccontent;
	}


	public void setReccontent_b(String reccontent_b) {
		this.reccontent_b = reccontent_b;
	}


	public void setReccontent_c(String reccontent_c) {
		this.reccontent_c = reccontent_c;
	}


	public void setReccontent_d(String reccontent_d) {
		this.reccontent_d = reccontent_d;
	}


	public void setReccontent_e(String reccontent_e) {
		this.reccontent_e = reccontent_e;
	}


	public void setReccontent_f(String reccontent_f) {
		this.reccontent_f = reccontent_f;
	}


	public void setRecimg(String recimg) {
		this.recimg = recimg;
	}


	public void setNewrecimg(String newrecimg) {
		this.newrecimg = newrecimg;
	}


	public void setRecimg_b(String recimg_b) {
		this.recimg_b = recimg_b;
	}


	public void setNewrecimg_b(String newrecimg_b) {
		this.newrecimg_b = newrecimg_b;
	}


	public void setRecimg_c(String recimg_c) {
		this.recimg_c = recimg_c;
	}


	public void setNewrecimg_c(String newrecimg_c) {
		this.newrecimg_c = newrecimg_c;
	}


	public void setRecimg_d(String recimg_d) {
		this.recimg_d = recimg_d;
	}


	public void setNewrecimg_d(String newrecimg_d) {
		this.newrecimg_d = newrecimg_d;
	}


	public void setRecimg_e(String recimg_e) {
		this.recimg_e = recimg_e;
	}


	public void setNewrecimg_e(String newrecimg_e) {
		this.newrecimg_e = newrecimg_e;
	}


	public void setRecimg_f(String recimg_f) {
		this.recimg_f = recimg_f;
	}


	public void setNewrecimg_f(String newrecimg_f) {
		this.newrecimg_f = newrecimg_f;
	}
	


	public int getDel() {
		return del;
	}





	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "RecipeDto [seq=" + seq + ", id=" + id + ", recipetitle=" + recipetitle + ", bestimg=" + bestimg
				+ ", newbestimg=" + newbestimg + ", recintroduce=" + recintroduce + ", reccategory=" + reccategory
				+ ", recperson=" + recperson + ", rectime=" + rectime + ", reclevel=" + reclevel + ", ingredient="
				+ ingredient + ", readcount=" + readcount + ", liked=" + liked + ", reccontent=" + reccontent
				+ ", reccontent_b=" + reccontent_b + ", reccontent_c=" + reccontent_c + ", reccontent_d=" + reccontent_d
				+ ", reccontent_e=" + reccontent_e + ", reccontent_f=" + reccontent_f + ", recimg=" + recimg
				+ ", newrecimg=" + newrecimg + ", recimg_b=" + recimg_b + ", newrecimg_b=" + newrecimg_b + ", recimg_c="
				+ recimg_c + ", newrecimg_c=" + newrecimg_c + ", recimg_d=" + recimg_d + ", newrecimg_d=" + newrecimg_d
				+ ", recimg_e=" + recimg_e + ", newrecimg_e=" + newrecimg_e + ", recimg_f=" + recimg_f
				+ ", newrecimg_f=" + newrecimg_f + ", del=" + del + "]";
	}
	
}


