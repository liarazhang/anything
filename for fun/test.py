import cv2 as cv

img = cv.imread("D:\python\est.jpg",0)
cv.namedWindow("Image")
cv.imshow("Image",img)
cv.waitKey(0)
cv.destroyAllWindows()