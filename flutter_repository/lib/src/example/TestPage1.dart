import 'package:flutter/cupertino.dart';

/// 测试页面1
class TestPage1 extends StatelessWidget {
  const TestPage1({super.key});

  @override
  Widget build(BuildContext context) {
    return const CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text('TestPage1'),
      ),
      child: Center(
        child: Text('TestPage1'),
      ),
    );
  }
}
