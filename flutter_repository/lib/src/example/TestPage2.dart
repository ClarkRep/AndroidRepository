import 'package:flutter/cupertino.dart';

/// 测试页面2
class TestPage2 extends StatelessWidget {
  const TestPage2({super.key});

  @override
  Widget build(BuildContext context) {
    return const CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text('TestPage2'),
      ),
      child: Center(
        child: Text('TestPage2'),
      ),
    );
  }
}
