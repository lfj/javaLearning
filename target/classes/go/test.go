package main

import "fmt"

/* 声明全局变量 */
var g int

func main() {
	fmt.Println("hello world!")
	a, b := swap("Google", "Runoob")
	fmt.Println(a, b)

	var ret int
	ret = max(100, 200)
	fmt.Printf("最大值是：%d\n", ret)

	var i int
	var balance1 = [5]float32{1000.0, 2.0, 3.4, 70.0, 10.0}
	for i = 0; i < 5; i++ {
		fmt.Printf("balance1[%d] = %f\n\n", i, balance1[i])
	}
	//balance2 := [5]float32{1000.0, 2.0, 3.4, 70.0, 10.0}

	// 切片
	var slice1 = make([]int, 4)
	printSlice(slice1)
}

// 返回两个参数的最大值
func max(num1 int, num2 int) int {
	// 声明局部变量
	var result int
	if num1 > num2 {
		result = num1
	} else {
		result = num2
	}
	return result
}

// 函数返回多个值
func swap(x, y string) (string, string) {
	return y, x
}

func printSlice(x []int) {
	fmt.Printf("len=%d cap=%d slice=%v\n", len(x), cap(x), x)
}
