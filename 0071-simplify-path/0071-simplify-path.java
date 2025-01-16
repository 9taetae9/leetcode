class Solution {
    public String simplifyPath(String path) {
        String[] canonical = path.replaceAll("/+","/").split("/");
            //String.join("/",path.split("/+"));
        Stack<String> stack = new Stack<>();
        
        for(int i=canonical.length - 1; i >= 0; i--){
            if(canonical[i].equals("")||canonical[i].equals(".")) continue;
            if(canonical[i].equals("..")) i--;
            else{
                stack.add(canonical[i]);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.pop());
        }
        
        
        return sb.toString();
    }
}


/*
'/'으로 시작하는 절대 주소 => 간소화된 canonical 경로

'.' : 현재 디렉토리
'..' : 이전/상위 디렉토리
'//', '///', '/' 과 동일

위의 규칙 제외 모든 문자열은 디렉토리 또는 파일명임

간소화된 canonical 경로
'/'으로 시작
'/'으로만 구분
'/'으로 끝나면 안됨(루트 디렉토리인 경우 제외)
'.','..' 없어야 함
*/