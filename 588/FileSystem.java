class FileSystem {
    static final String SPLITTER = "/";
    Directory root;
    public FileSystem() {
        root = new Directory(SPLITTER);
    }
    
    public List<String> ls(String path) {
        if(path.equals(SPLITTER))
            return root.getFileAndSubDirectories();
        Directory d = getCorrespondingDirectory(path, true);
        String filename = path.substring(path.lastIndexOf(SPLITTER) + 1);
        boolean foundDirectory = false;
        for(Directory ds: d.sub){
            if(ds.toString().equals(filename)){
                foundDirectory = true;
                break;
            }
        }
        if(foundDirectory)
            return d.getSubDirectory(filename).getFileAndSubDirectories();
        List<String> l = new LinkedList<String>();
        l.add(filename);
        return l;
    }
    
    public void mkdir(String path) {
        getCorrespondingDirectory(path, false);
    }
    
    public void addContentToFile(String filePath, String content) {
        Directory d = getCorrespondingDirectory(filePath, true);
        String filename = filePath.substring(filePath.lastIndexOf(SPLITTER) + 1);
        d.setContent(filename, content);
    }
    
    public String readContentFromFile(String filePath) {
        Directory d = getCorrespondingDirectory(filePath, true);
        String filename = filePath.substring(filePath.lastIndexOf(SPLITTER) + 1);
        return d.getContent(filename);
    }
    
    private Directory getCorrespondingDirectory(String path, boolean isFile){
        path = path.substring(1);
        if(path.length() == 0)
            return root;
        String[] ds = path.split(SPLITTER);
        Directory ret = root;
        if(isFile){
            for(int i = 0; i < ds.length - 1; i++){
                ret = ret.getSubDirectory(ds[i]);
            }
        } else {
            for(int i = 0; i < ds.length; i++){
                ret = ret.getSubDirectory(ds[i]);
            }
        }
        return ret;
    }
    
    class Directory{
        String name;
        Set<Directory> sub;
        Map<String, String> files;
        Directory(String name){
            this.name = name;
            sub = new HashSet<Directory>();
            files = new HashMap<String, String>();
        }
        
        String getContent(String filename){
            return files.getOrDefault(filename, "");
        }
        
        void setContent(String filename, String content){
            files.put(filename, files.getOrDefault(filename, "") + content);
        }
        
        Directory getSubDirectory(String subname){
            for(Directory d: sub){
                // System.out.println(d);
                if(d.toString().equals(subname)){
                    return d;
                }
            }
            Directory ret = new Directory(subname);
            sub.add(ret);
            return ret;
        }
        
        List<String> getFileAndSubDirectories(){
            List<String> ret = new LinkedList<String>();
            for(Directory d: sub){
                ret.add(d.toString());
            }
            for(String file: files.keySet()){
                ret.add(file);
            }
            Collections.sort(ret);
            return ret;
        }
        
        @Override
        public String toString(){
            return name;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */