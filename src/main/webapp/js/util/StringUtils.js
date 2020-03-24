var str = "abc123abc";

/*判断字符串中是否含有某些字符
* 如果含有该字符则返回该字符首次出现的位置，如果没有则返回-1*/
str.indexOf("d")


/*截取字符串
* substring(start,end)表示截取从start到end的字符串，
* 包括start位置的字符但是不包括end位置的字符*/
str.substring(1,2)

/*截取固定长度的字符串
* substr(start,length)表示从start位置开始，截取length长度的字符串*/
str.substr(1,2)

/*按照指定字符分割字符串
* split("|")使用一个指定的分隔符把一个字符串分割存储到数组*/
str.split("abc")

/*把数组合并成字符串
* john("|")使用选择的分隔符将一个数组合并为一个字符串*/
var johnStr =[1,5,7]
johnStr.join("-")

/*转换成百分数
* js的除法就是我们的数学除法，不跟JAVA一样，不做向下取整
* round() 方法可把一个数字舍入为最接近的整数。*/
function percent(number1, number2) {
    return (Math.round(number1 / number2 * 10000) / 100 + "%");// 小数点后两位百分比
}



