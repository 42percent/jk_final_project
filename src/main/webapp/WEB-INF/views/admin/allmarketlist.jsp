<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<!-- 클래스리스트, 총수 
<select id="allclasslist" parameterType="bit.your.prj.dto.Param" resultType="bit.your.prj.dto.CCDto">
	SELECT SEQ, NICKNAME, TITLE, LOCATION, KINDS, READCOUNT, CONTENT, MEMBERNUM, RDATE, EDATE,
		   CDATE, FILENAME, NEWFILENAME, DEL	
	FROM	   
		(SELECT ROW_NUMBER()OVER(ORDER BY SEQ DESC) AS RNUM,
		   SEQ, NICKNAME, TITLE, LOCATION, KINDS, READCOUNT, CONTENT, MEMBERNUM, RDATE, EDATE,
		   CDATE, FILENAME, NEWFILENAME, DEL	
		FROM COOKCLASS   		
		WHERE 1=1
		<if test="choice != null and choice != '' and search != null and search != ''">
			<if test="choice == 'title'">
				AND TITLE LIKE '%'||#{search}||'%'
			</if>
			<if test="choice == 'kinds'">
				AND KINDS LIKE '%'||#{search}||'%'
			</if>
			<if test="choice == 'nickname'">
				AND NICKNAME=#{search}
			</if>
		</if>
		ORDER BY SEQ DESC)
	WHERE RNUM BETWEEN ${start} AND ${end}	
</select>

<select id="getClassCount" parameterType="bit.your.prj.dto.Param" resultType="Integer">
	SELECT NVL(COUNT(*), 0)
	FROM COOKCLASS
	WHERE 1=1
	<if test="choice != null and choice != '' 
		and search != null and search != ''">
		<if test="choice == 'title'">
			AND TITLE LIKE '%'||#{search}||'%'
		</if>
		<if test="choice == 'kinds'">
			AND KINDS LIKE '%'||#{search}||'%'
		</if>
		<if test="choice == 'nickname'">
			AND NICKNAME=#{search}
		</if>
	</if>
	-->