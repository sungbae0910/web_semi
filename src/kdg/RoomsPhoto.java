package kdg;

public class RoomsPhoto {
  String OriFile;
  String SysFile;
	
  public RoomsPhoto() {
	  
  }

public String getOriFile() {
	return OriFile;
}

public void setOriFile(String oriFile) {
	this.OriFile = oriFile;
}

public String getSysFile() {
	return SysFile;
}

public void setSysFile(String sysFile) {
	this.SysFile = sysFile;
}

public RoomsPhoto(String OriFile, String SysFile) {
	this.OriFile = OriFile;
	this.SysFile = SysFile;
}
	
}
