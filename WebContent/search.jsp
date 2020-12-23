<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/search.css">
</head>
<body>
    <div>
        <div class="search-main">
            <div>
                <div class="category">
                    <div class="search-category pick">아이디로 찾기</div>
                    <div class="search-category">비밀번호로 찾기</div>
                </div>
            </div>
            <div class="search-form choose">
                <div class="reg-form-container">
                    <div class="reg-form-item">
                        <label style="font-size: 15px;" for="email" title="이메일">
                            <em style="color: red;">*</em>
                            이름
                        </label>
                        <div class="input-box">
                            <div>
                                <input type="name check-validation" class="email check-validation"  
                                placeholder="성명" id="email" name="email" autocorrect="off" 
                                autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                
                            </div>
                        </div>
                    </div>
                    <div class="reg-form-item">
                        <label style="font-size: 15px;" for="phone" title="비밀번호">
                            <em style="color: red;">*</em>
                            휴대폰번호
                        </label>
                        <div class="input-box">
                            <div>
                                <input type="text" class="phone check-validation" 
                                placeholder="010-0000-0000" id="phone" name="phone" autocorrect="off" 
                                autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                
                            </div>
                        </div>
                    </div>
                    <button class="button e">검색</button>
                </div>
            </div>
            <div class="search-form">
                <div class="reg-form-container">
                    <div class="reg-form-item">
                        <label style="font-size: 15px;" for="name" title="이메일">
                            <em style="color: red;">*</em>
                            이름
                        </label>
                        <div class="input-box">
                            <div>
                                <input type="name" class="name check-validation"  
                                placeholder="성명" id="name" name="name" autocorrect="off" 
                                autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                
                            </div>
                        </div>
                    </div>
                    <div class="reg-form-item">
                        <label style="font-size: 15px;" for="email" title="이메일">
                            <em style="color: red;">*</em>
                            이메일
                        </label>
                        <div class="input-box">
                            <div>
                                <input type="email" class="email check-validation"  
                                placeholder="ddd@ddd.dd" id="email" name="email" autocorrect="off" 
                                autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                
                            </div>
                        </div>
                    </div>
                    <div class="reg-form-item">
                        <label style="font-size: 15px;" for="phone" title="비밀번호">
                            <em style="color: red;">*</em>
                            휴대폰번호
                        </label>
                        <div class="input-box">
                            <div>
                                <input type="text" class="phone check-validation" 
                                placeholder="010-0000-0000" id="phone" name="phone" autocorrect="off" 
                                autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                
                            </div>
                        </div>
                    </div>
                    <button class="button p">검색</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>