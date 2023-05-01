int findMin(int[] A, int n) { //A는 배열기반 최대힙을 가정
  int minValue = A[0]; // 루트 노드에서 시작
  int idx = 0; // 루트 노드의 인덱스를 저장.

  while (idx * 2 + 1 < n) { // 왼쪽 자식이 있는 동안 반복
    int leftChild = A[idx * 2 + 1];
    int rightChild = (idx * 2 + 2 < n) ? A[idx * 2 + 2] : Integer.MAX_VALUE; 
    // 오른쪽 자식이 없으면 무한대 값

    if (leftChild < minValue) 
        minValue = leftChild; 
    
    if (rightChild < minValue) 
        minValue = rightChild; 
    
    // 더 작은 자식 노드로 이동
    if (leftChild < rightChild) 
      idx = idx * 2 + 1;
    else 
      idx = idx * 2 + 2;
    
  }

  return minValue; 
}
