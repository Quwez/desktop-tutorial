import json
import sys
from binary_heap import BinaryHeap


class Task:
    def __init__(self, task_id, duration, deadline, order):
        self.id = str(task_id)
        self.duration = int(duration)
        self.deadline = int(deadline)
        self.order = int(order)


def read_tasks(lines):
    tasks = []
    for idx, line in enumerate(lines):
        line = line.strip()
        if not line:
            continue
        obj = json.loads(line)
        tasks.append(Task(obj["id"], obj["duration"], obj["deadline"], idx))
    return tasks


def solve(tasks):
    if not tasks:
        return []

    sorted_tasks = sorted(tasks, key=lambda t: t.deadline)
    heap = BinaryHeap(key=lambda t: (t.duration, t.order), is_max=True)

    current_time = 0
    for task in sorted_tasks:
        heap.push(task)
        current_time += task.duration
        if current_time > task.deadline:
            longest = heap.pop()
            current_time -= longest.duration

    chosen_orders = {t.order for t in heap.data}
    return [t.id for t in sorted_tasks if t.order in chosen_orders]


def main():
    tasks = read_tasks(sys.stdin)
    print(json.dumps(solve(tasks)))


if __name__ == "__main__":
    main()