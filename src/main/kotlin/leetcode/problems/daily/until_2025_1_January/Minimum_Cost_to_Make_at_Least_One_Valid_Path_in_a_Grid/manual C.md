## 1368. Minimum Cost to Make at Least One Valid Path in a Grid

```
#include <stdlib.h>
#include <limits.h>

#define MAX_SIZE 100 

typedef struct Node {
    int r, c, cost;
    struct Node *prev, *next;
} Node;

typedef struct Deque {
    Node *front, *rear;
} Deque;

typedef struct Direction {
    int key;
    struct {int x, y;} pair;
} Direction;

void initDeque(Deque *deque) {
    deque->front = deque->rear = NULL;
}

void pushFront(Deque *deque, int r, int c, int cost) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->r = r;
    newNode->c = c;
    newNode->cost = cost;
    newNode->prev = NULL;
    newNode->next = deque->front;
    
    if (deque->front == NULL) {
        deque->rear = newNode;
    } else {
        deque->front->prev = newNode;
    }
    deque->front = newNode;
}

void pushRear(Deque *deque, int r, int c, int cost) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->r = r;
    newNode->c = c;
    newNode->cost = cost;
    newNode->prev = deque->rear;
    newNode->next = NULL;
    
    if (deque->rear == NULL) {
        deque->front = newNode;
    } else {
        deque->rear->next = newNode;
    }
    deque->rear = newNode;
}

Node* popFront(Deque *deque) {
    if (deque->front == NULL) return NULL;
    Node *temp = deque->front;
    deque->front = deque->front->next;
    if (deque->front == NULL) {
        deque->rear = NULL;
    } else {
        deque->front->prev = NULL;
    }
    return temp;
}

int minCost(int** grid, int gridSize, int* gridColSize) {
    int n = gridSize, m = gridColSize[0];
    
    Direction directions[] = {
        {1, {0,1}},
        {2, {0, -1}},
        {3, {1, 0}},
        {4, {-1, 0}},
    };

    Deque deque;
    initDeque(&deque);
    pushFront(&deque, 0, 0, 0);

    int minCost[MAX_SIZE][MAX_SIZE]; 
    for (int i = 0; i < MAX_SIZE; i++) {
        for (int j = 0; j < MAX_SIZE; j++) {
            minCost[i][j] = INT_MAX;
        }
    }
    minCost[0][0] = 0;

    while (deque.front != NULL) {
        Node *current = popFront(&deque);
        int r = current->r, c = current->c, cost = current->cost;
        free(current);

        if (r == n - 1 && c == m - 1) return cost;

        for (int i = 0; i < sizeof(directions) / sizeof(directions[0]); i++) {
            Direction dir = directions[i];
            int nr = r + dir.pair.x, nc = c + dir.pair.y;
            int newCost = (dir.key == grid[r][c]) ? cost : cost + 1;

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || newCost >= minCost[nr][nc]) {
                continue;
            }

            minCost[nr][nc] = newCost;
            if (dir.key == grid[r][c]) {
                pushFront(&deque, nr, nc, newCost);
            } else {
                pushRear(&deque, nr, nc, newCost);
            }
        }
    }

    return -1; 
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```